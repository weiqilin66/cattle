package org.wayne.thief.config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * @Description:
 * @author: lwq
 */
@Configuration
public class SeleniumConfig {

    @Bean
    ChromeDriver config(){
        ChromeOptions options = new ChromeOptions();
        // 设置为开发者模式，防止被各大网站识别出来使用了Selenium  window.navigator.webdriver检测
        // 高版本无法使用
//        options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));

        // 不加载图片
        HashMap<String, Object> prefs = new HashMap<>(1);
        prefs.put("profile.default_content_settings", 2);
        options.setExperimentalOption("prefs", prefs);
        // 屏蔽webdriver特征
        options.addArguments("--disable-blink-features");
        options.addArguments("--disable-blink-features=AutomationControlled");
        String url = "https://s.taobao.com/";
        ChromeDriver driver = new ChromeDriver(options);
        driver.get(url);
        return driver;
    }


}
