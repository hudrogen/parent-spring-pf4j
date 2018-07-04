package com.hudrogen.demo.api.impl;

import com.hudrogen.controller.BaseController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Предназначение контроллера - т.к. базовое приложение не видит реализации интерфейса BaseController
 * Нужно создать реализацию - заглушку для этого интерфейса*/
//todo выяснить возможно это и не нужно
@RestController
public class InnerBaseControllerImpl implements BaseController {

    @RequestMapping("/fakeCalc")
    public String calcMetric() {
        return "fake";
    }

    @RequestMapping("/fakeGetMetric")
    public String getMetric() {
        return "fake";
    }
}
