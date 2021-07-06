package org.wayne.thief.util;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.util.StringValueResolver;

/**
 * @Description:
 * @author: lwq
 */
public class SeUtil implements EmbeddedValueResolverAware, ApplicationContextAware {
    private static ChromeDriver chromeDriver;
    private static ApplicationContext context;
    private static StringValueResolver resolver;

    public synchronized static ChromeDriver getChromeDriver(){
        if (chromeDriver==null) {
            final ChromeOptions chromeOptions = context.getBean("chromeOptions", ChromeOptions.class);
            chromeDriver =  new ChromeDriver(chromeOptions);
        }
        return chromeDriver;
    }

    @Override
    public void setEmbeddedValueResolver(StringValueResolver stringValueResolver) {
        resolver = stringValueResolver;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context=applicationContext;
    }
}
