package com.chengli.base;

import com.chengli.bean.init.OuterBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by chengli on 2015/11/17.
 */
public class MainClazz {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext("com.chengli.bean.init");
        OuterBean outerBean = applicationContext.getBean(OuterBean.class);
    }
}
