package com.hudrogen.demo.web;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.pf4j.ExtensionFactory;
import org.pf4j.PluginWrapper;
import org.pf4j.spring.SpringPluginManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

/**
 * Чтобы диспатчер сервлет создался после подгрузки контекста с плагина
 * Пример взят отсюда
 * https://github.com/pf4j/pf4j/issues/126#issuecomment-281388628
 * */

@Service
public class SpringPluginStarter {

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private AbstractAutowireCapableBeanFactory beanFactory;

    private static final Logger log = LoggerFactory.getLogger(SpringPluginStarter.class);

    @PostConstruct
    public void init() {

        initExtensionInjector();
    }

    public void initExtensionInjector() {
        SpringPluginManager pluginManager = new SpringPluginManager();
        pluginManager.loadPlugins();
        pluginManager.startPlugins();
        pluginManager.setApplicationContext(applicationContext);
        ExtensionFactory extensionFactory = pluginManager.getExtensionFactory();

        // add extensions from classpath (non plugin)
        Set<String> extensionClassNames = pluginManager.getExtensionClassNames(null);
        for (String extensionClassName : extensionClassNames) {
            try {
                log.debug("Register extension '{}' as bean", extensionClassName);
                Class<?> extensionClass = getClass().getClassLoader().loadClass(extensionClassName);
                beanFactory.registerSingleton(extensionClassName, extensionFactory.create(extensionClass));
            } catch (ClassNotFoundException e) {
                log.error(e.getMessage(), e);
            }
        }

        // add extensions for each started plugin
        List<PluginWrapper> startedPlugins = pluginManager.getStartedPlugins();
        for (PluginWrapper plugin : startedPlugins) {
            log.debug("Registering extensions of the plugin '{}' as beans", plugin.getPluginId());
            extensionClassNames = pluginManager.getExtensionClassNames(plugin.getPluginId());
            for (String extensionClassName : extensionClassNames) {
                try {
                    log.debug("Register extension '{}' as bean", extensionClassName);
                    Class<?> extensionClass = plugin.getPluginClassLoader().loadClass(extensionClassName);
                    beanFactory.registerSingleton(extensionClassName, extensionFactory.create(extensionClass));
                } catch (ClassNotFoundException e) {
                    log.error(e.getMessage(), e);
                }
            }
        }
    }
}