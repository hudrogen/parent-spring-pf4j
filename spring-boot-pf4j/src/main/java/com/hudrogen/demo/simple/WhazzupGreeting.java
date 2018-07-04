package com.hudrogen.demo.simple;

import com.hudrogen.api.Greeting;
import org.springframework.stereotype.Component;

/*Чтобы спринг не ругался что не может проинжектить бин*/
@Component
public class WhazzupGreeting implements Greeting {
    @Override
    public String getGreeting() {
        return "Whazzup";
    }
}
