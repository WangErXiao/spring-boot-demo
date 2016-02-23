package com.example.factory;

import com.example.People;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

/**
 * Created by yao on 16/2/23.
 */
@Component
public class MyFactoryBean implements FactoryBean<People> {

    @Override
    public People getObject() throws Exception {
        People p=new People();
        p.setName(System.currentTimeMillis()+"");
        return p;
    }
    @Override
    public Class<?> getObjectType() {
        return People.class;
    }
    @Override
    public boolean isSingleton() {
        return false;
    }
}
