package com.hudrogen.demo.web;

import com.hudrogen.controller.BaseController;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Возможно класс-обертку создавать и не надо
 * Попробовать автовайрить лист бинов сразу*/
public class BaseControllers {

    @Autowired
    private List<BaseController> baseControllerList;

    public List<BaseController> getBaseControllerList() {
        return baseControllerList;
    }

    public void setBaseControllerList(List<BaseController> baseControllerList) {
        this.baseControllerList = baseControllerList;
    }
}
