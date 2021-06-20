package org.wayne.getbean;

import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.wayne.BeanPostProcessorDemo;

/**
 * @TODO:
 * @author: lwq
 */
@Configuration
@ComponentScan("org.wayne")
public class Config {

    @Bean
    BeanPostProcessor beanPostProcessor2(){
        return new BeanPostProcessorDemo();
    }

    @Bean
    User user1(){
        return new Tom();
    }
    @Bean
    User user2(){
        return new Jerry();
    }
}
