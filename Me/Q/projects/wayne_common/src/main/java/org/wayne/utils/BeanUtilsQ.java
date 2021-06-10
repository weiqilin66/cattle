package org.wayne.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.util.Map;

/**
 * @Description: 用于获取Spring容器中的Bean
 * ApplicationContextAware
 * aware注入
 * setApplicationContext()方法传入的参数为spring启动时候的上下文
 * 开发时并不是每个地方都能使用属性注入,例如Utils中使用到dao层,就不去注入,利用spring上下文来获取bean(dao实例)
 * @author: lwq
 */
public class BeanUtilsQ implements ApplicationContextAware {
    private static Logger log = LoggerFactory.getLogger(BeanUtilsQ.class);
    private static ApplicationContext applicationContext;

    private BeanUtilsQ() {
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        log.info("初始化Spring应用上线文");
        if (BeanUtilsQ.applicationContext == null) {
            BeanUtilsQ.applicationContext = applicationContext;
        }
    }

    public static Object getBean(String name) {
        return getApplicationContext().getBean(name);
    }

    public static <T> T getBean(Class<T> cls) {
        return getApplicationContext().getBean(cls);
    }

    public static <T> Map<String, T> getBeansOfType(Class<T> cls) {
        return getApplicationContext().getBeansOfType(cls);
    }

    public static <T> T getBean(String name, Class<T> cls) {
        return getApplicationContext().getBean(name, cls);
    }

    private static ApplicationContext getApplicationContext() {
        if (null == applicationContext) {
            throw new NullPointerException("应用上下文对象为空");
        } else {
            return applicationContext;
        }
    }
}
