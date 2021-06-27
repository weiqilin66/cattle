package org.wayne.auto;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * @Description:
 * @author: lwq
 */
public class SeleniumApp {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "D:\\selenium_driver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.itest.info");

        String title = driver.getTitle();
        System.out.printf(title);

        driver.close();
    }
}

