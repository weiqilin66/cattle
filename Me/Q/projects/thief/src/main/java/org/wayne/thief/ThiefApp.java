package org.wayne.thief;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Description:
 * @author: lwq
 */
@SpringBootApplication
public class ThiefApp {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
        SpringApplication.run(ThiefApp.class,args);
    }
}
