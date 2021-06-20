package org.wayne.getbean;

import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.wayne.BeanPostProcessorDemo;
import org.wayne.getbean.Config;

/**
 * @TODO:
 * @author: lwq
 */
public class Test {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext =new AnnotationConfigApplicationContext(Config.class);

        final User bean2 = applicationContext.getBean(Tom.class);
        final User bean3 = applicationContext.getBean(Jerry.class);
        final User bean = applicationContext.getBean(User.class);
        final User bean4 = bean;

    }
}

