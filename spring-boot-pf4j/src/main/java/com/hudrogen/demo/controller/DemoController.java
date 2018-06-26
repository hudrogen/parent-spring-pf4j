package com.hudrogen.demo.controller;

import org.pf4j.spring.SpringPluginManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @Autowired
    private SpringPluginManager springPluginManager;


    @RequestMapping("/test")
    public String getDempString(){
        return springPluginManager.getSystemVersion();
    }
}
