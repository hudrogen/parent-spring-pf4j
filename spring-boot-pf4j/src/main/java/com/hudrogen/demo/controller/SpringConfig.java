package com.hudrogen.demo.controller;

import org.pf4j.spring.SpringPluginManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Bean
    public SpringPluginManager pluginManager(){
        return new SpringPluginManager();
    }

}
