package com.example.annotation;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * Created by yao on 16/3/7.
 */

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface MyAnno {


}
