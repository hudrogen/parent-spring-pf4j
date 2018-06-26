package com.hudrogen.plugins.firstplugin;

import org.pf4j.PluginWrapper;
import org.pf4j.spring.SpringPlugin;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Своеобразная точка входа в плагин.
 * В этой точке входе возвращается спринг контекст этого плагина
 * Далее он присединяется к контексту основного приложения*/
public class MyPlugin extends SpringPlugin {
    public MyPlugin(PluginWrapper wrapper) {
        super(wrapper);
    }

    @Override
    protected ApplicationContext createApplicationContext() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.setClassLoader(getWrapper().getPluginClassLoader());
        applicationContext.register(SpringConfiguration.class);
        applicationContext.refresh();
        return applicationContext;
    }

    @Override
    public void start() {
        System.out.println("MyPlugin.start()");
    }

    @Override
    public void stop() {
        System.out.println("MyPlugin.stop()");
        super.stop(); // to close applicationContext
    }
}