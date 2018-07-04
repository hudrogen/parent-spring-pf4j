package com.hudrogen.demo.config;

import com.hudrogen.demo.web.SpringPluginStarter;
import com.hudrogen.demo.simple.Greetings;
import com.hudrogen.demo.web.BaseControllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Конфигурация спринга, при котором контроллеры в плагинах работают как контроллеры
 * Зависит от springPluginStartet*/

@Configuration
@ComponentScan("com.hudrogen")
public class WebConfig extends WebMvcConfigurerAdapter {

    @Autowired
    private SpringPluginStarter springPluginStarter;

    @Bean
    @DependsOn("springPluginStarter")
    public Greetings greetings() {
        return new Greetings();
    }

    @Bean
    @DependsOn("springPluginStarter")
    public BaseControllers pluginControllers() {
        return new BaseControllers();
    }

}