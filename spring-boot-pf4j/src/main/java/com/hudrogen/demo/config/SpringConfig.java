package com.hudrogen.demo.config;

import com.hudrogen.demo.simple.Greetings;
import com.hudrogen.demo.web.BaseControllers;
import org.pf4j.spring.SpringPluginManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.DependsOn;

/**
 * Конфигурация спринга для работы плагин менеджера,
 * при котором контроллеры в плагинах не работают как контроллеры*/

//@Configuration
//@ComponentScan("com.hudrogen")
public class SpringConfig {

    //@Bean
    public SpringPluginManager pluginManager() {
        return new SpringPluginManager();
    }

    //@Bean
    //@DependsOn("pluginManager")
    public Greetings greetings() {
        return new Greetings();
    }

    //@Bean
    //@DependsOn("pluginManager")
    public BaseControllers pluginControllers() {
        return new BaseControllers();
    }
}
