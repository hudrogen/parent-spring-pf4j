package ru.innopolis.autowiredplugin;

import org.springframework.stereotype.Component;

@Component("myAutowiredComponent")
public class MyAutowiredComponent {

    public String getMessage(){
        return "String from autowired plugin";
    }

}
