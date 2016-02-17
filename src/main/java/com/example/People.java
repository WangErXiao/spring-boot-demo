package com.example;

import java.io.Serializable;

/**
 * Created by yao on 16/2/17.
 */
public class People implements Serializable {

    private static final long serialVersionUID = 7374661414650314957L;

    private String name;
    private Integer age;

    private String msg;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
