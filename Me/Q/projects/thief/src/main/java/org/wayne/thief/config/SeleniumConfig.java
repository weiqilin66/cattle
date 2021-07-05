package org.wayne.thief.config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;

/**
 * @Description:
 * @author: lwq
 */
@Configuration
public class SeleniumConfig {


    static void config(){
        ChromeOptions options = new ChromeOptions();
        // 设置为开发者模式，防止被各大网站识别出来使用了Selenium  window.navigator.webdriver检测
        options.setExperimentalOption("excludeSwitches", "enable-automation");
        // 不加载图片
        HashMap<String, Object> prefs = new HashMap<>();
        prefs.put("profile.default_content_settings", 2);
        options.setExperimentalOption("prefs", prefs);
        String url = "https://s.taobao.com/";
        WebDriver driver = new ChromeDriver(options);
        driver.get(url);
    }

    public static void main(String[] args) {
        config();
    }

}
