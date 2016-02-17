package com.example.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by yao on 16/2/17.
 */
@Component
public class HelloService {

    @Value("${name:NoBody}")
    private String name;

    public String hello(String some) {
        return name+" say: Hello to"+some ;
    }
}
