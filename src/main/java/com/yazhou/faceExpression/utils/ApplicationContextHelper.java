package com.yazhou.faceExpression.utils;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by root on 12/29/15.
 */
public class ApplicationContextHelper {
    private static ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");

    public static Object getBean(String beanName){
        return ctx.getBean(beanName);
    }
}
