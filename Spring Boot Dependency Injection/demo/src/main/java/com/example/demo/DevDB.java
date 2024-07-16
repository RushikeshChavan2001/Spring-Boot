package com.example.demo;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(name="deploy.env" ,havingValue = "dev")

public class DevDB implements DB{

    @Override
    public String getData() {
        return "DevDB";
    }
}
