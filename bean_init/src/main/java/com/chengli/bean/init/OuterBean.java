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
 * ⑥ 如果实现了BeanPostProcessor 则调用postProcessBeforeInitialization
 * ⑦ 如果实现了InitializingBean 则调用afterPropertiesSet，如果该方法用init-method实现了初始化方法，afterPropertiesSet也会被调用
 * ⑧ 如果实现了BeanPostProcessor 则调用postProcessAfterInitialization
 * ⑨ 如果实现了DisposableBean 则调用destroy
 *
 * Created by chengli on 2015/11/17.
 */
@Service
public class OuterBean implements BeanNameAware, BeanFactoryAware, ApplicationContextAware, BeanPostProcessor, InitializingBean, DisposableBean {

    public OuterBean() {
        System.out.println("① OuterBean contrustor");
    }

    /**
     * @param name
     */
    public void setBeanName(String name) {
        System.out.println("③ set OuterBean name:" + name);
    }

    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("④ set OuterBean beanFactory:" + beanFactory);
    }

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("⑤ set OuterBean applicationContext:" + applicationContext);
    }

    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("⑥ postProcessBeforeInitialization");
        return new Object();
    }

    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("⑧ postProcessAfterInitialization");
        return null;
    }

    public void destroy() throws Exception {
        System.out.println("destory");
    }

    public void afterPropertiesSet() throws Exception {
        System.out.println("⑦ after properties set~!~");
    }
}
