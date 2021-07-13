package org.wayne.thief;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @Description: 爬
 * @author: lwq
 */
@SpringBootApplication
@EnableScheduling
public class ThiefApp {
    public static void main(String[] args) {
        SpringApplication.run(ThiefApp.class,args);
    }
}
