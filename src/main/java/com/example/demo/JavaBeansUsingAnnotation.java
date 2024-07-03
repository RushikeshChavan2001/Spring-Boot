package com.example.demo;

import org.springframework.stereotype.Component;
@Component

public class JavaBeansUsingAnnotation {
    void message(){
        System.out.println("hi");
    }

    void message2(){
        System.out.println("hi from annotation file");
    }
}
