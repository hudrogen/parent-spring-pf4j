package com.hudrogen.demo;

import com.hudrogen.controller.BaseController;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

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
