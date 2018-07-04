package com.hudrogen.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * Проверка что Spring Web приложение вообще запустилось*/
@RestController
public class DemoController {

    @RequestMapping("/test")
    public String getDempString(){
        return "hardcode";
    }
}
