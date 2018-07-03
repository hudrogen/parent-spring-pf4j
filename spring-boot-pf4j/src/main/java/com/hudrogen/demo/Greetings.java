package com.hudrogen.demo;

import com.hudrogen.api.Greeting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


public class Greetings {

    @Autowired
    private List<Greeting> greetings;

    public void printGreetings() {
        System.out.println(String.format("Found %d extensions for extension point '%s'", greetings.size(), Greeting.class.getName()));
        for (Greeting greeting : greetings) {
            System.out.println(">>> " + greeting.getGreeting());
        }
    }

    public String getGreetings(){
        StringBuffer sb = new StringBuffer();
        for (Greeting greeting : greetings) {
            sb.append(greeting.getGreeting());
        }
        return sb.toString();
    }

}