package com.hudrogen.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


@Configuration
@ComponentScan("com.hudrogen")
public class WebConfigurer extends WebMvcConfigurerAdapter {

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