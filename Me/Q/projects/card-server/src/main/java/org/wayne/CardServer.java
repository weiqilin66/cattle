package org.wayne;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @Description: 二手卡
 * @author: lwq
 */
@SpringBootApplication
public class CardServer {
    public static void main(String[] args) {
        final ConfigurableApplicationContext env = SpringApplication.run(CardServer.class, args);

    }
}
