package com.example.oms.model;

import org.springframework.stereotype.Component;

@Component
public class HelloBean {
    public HelloBean() {
        System.out.println("Bean created!");
    }
}
