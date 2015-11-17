package com.chengli.bean.init;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

/**
 * 此bean 用于模拟整个bean的生命周期（初始化顺序）
 * ① 实例化Bean
 * ② 将值和Bean的引用注入进Bean对应的属性中
 * ③ 如果bean实现了BeanNameAware则调用setBeanName方法，将Bean的ID传递给Bean
 * ④ 如果bean实现了BeanFactoryAware则调用setBeanFactory方法
 * ⑤ 如果实现了ApplicationContextAware则调用setApplicationContext
 * Created by chengli on 2015/11/17.
 */
@Service
public class OuterBean implements BeanNameAware, BeanFactoryAware, ApplicationContextAware, BeanPostProcessor, InitializingBean, DisposableBean {

    public OuterBean() {
        System.out.println("OuterBean contrustor");
    }

    /**
     * @param name
     */
    public void setBeanName(String name) {
        System.out.println("set OuterBean name:" + name);
    }

    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("set OuterBean beanFactory:" + beanFactory);
    }

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("set OuterBean applicationContext:" + applicationContext);
    }

    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("postProcessBeforeInitialization");
        return null;
    }

    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("postProcessAfterInitialization");
        return null;
    }

    public void destroy() throws Exception {
        System.out.println("destory");
    }

    public void afterPropertiesSet() throws Exception {
        System.out.println("after properties set~!~");
    }
}
