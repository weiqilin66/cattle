package org.wayne.menu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Description: @SpringCloudApplication = springbootApplication+discovery+enableCircuitBreaker
 * @author: LinWeiQi
 */
//@SpringCloudApplication
@MapperScan("org.wayne.menu.mapper")
@SpringBootApplication
@EnableDiscoveryClient
public class MenuServiceApp {
    public static void main(String[] args) {

        SpringApplication.run(MenuServiceApp.class,args);
    }

}
