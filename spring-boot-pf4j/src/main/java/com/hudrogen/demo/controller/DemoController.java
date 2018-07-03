package com.hudrogen.demo.controller;


import com.hudrogen.demo.Greetings;
import org.pf4j.PluginWrapper;
import org.pf4j.spring.SpringPluginManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DemoController {


    @Autowired
    private ApplicationContext context;


    @RequestMapping("/test")
    public String getDempString(){
        return "hardcode";
    }

    @RequestMapping("/tricky")
    public String getTrickyString(){
        Greetings greetings = context.getBean(Greetings.class);
        return greetings.getGreetings();
    }
}
