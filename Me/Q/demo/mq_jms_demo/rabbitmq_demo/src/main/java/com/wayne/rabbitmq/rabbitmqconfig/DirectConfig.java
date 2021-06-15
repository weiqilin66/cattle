package com.wayne.rabbitmq.rabbitmqconfig;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description: provide->exchange->binding->queue->consumer
 * @author: LinWeiQi
 */
@Configuration
public class DirectConfig {
    public static final String directName = "exchange1";

    //消息队列
    @Bean
    Queue queue(){
        return new Queue("myQ");
    }

    //durable重启有效 autoDelete长期不适用是否删除
    //exchange
    @Bean
    DirectExchange directExchange(){
        return new DirectExchange(directName,true,false);
    }

    //directExchange:消息提供者将消息加入routingKey的队列中
    @Bean
    Binding binding(){
        return BindingBuilder.bind(queue()).to(directExchange()).with("direct");
    }
}
