package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class JavaBeanUsingConfig {
    @Bean
    //@Scope(value = "prototype")
    @Scope("prototype")
    JavaBeanUsingConfig message(){
//        System.out.println("Hi From Config file");

        return  new JavaBeanUsingConfig();
    }

}
