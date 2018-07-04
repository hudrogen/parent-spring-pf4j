package com.hudrogen.demo;

import com.hudrogen.controller.BaseController;
import org.pf4j.spring.SpringPluginManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import java.util.List;

@Configuration
@ComponentScan("com.hudrogen")
public class SpringConfig {

    @Bean
    public SpringPluginManager pluginManager() {
        return new SpringPluginManager();
    }

    @Bean
    @DependsOn("pluginManager")
    public Greetings greetings() {
        return new Greetings();
    }

    @Bean
    @DependsOn("pluginManager")
    public BaseControllers pluginControllers() {
        return new BaseControllers();
    }
}
