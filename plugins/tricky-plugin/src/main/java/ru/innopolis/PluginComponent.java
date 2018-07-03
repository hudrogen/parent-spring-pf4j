package ru.innopolis;

import org.springframework.stereotype.Component;

@Component("plugincomponent")
public class PluginComponent {

    public String getSomeText(){
        return "Some fucking text";
    }

}
