package com.example.service;

import com.example.annotation.MyAnno;

/**
 * Created by yao on 16/3/7.
 */
@MyAnno
public class MyService {


    public String sayHello(){

        System.out.println("my service .......");

        return "hello";
    }
}
