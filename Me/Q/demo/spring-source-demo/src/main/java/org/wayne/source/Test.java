package org.wayne.source;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.wayne.getbean.Config;

/**
 * @Description:  spring 源码解析入口
 * @author: lwq
 */
public class Test {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext =new AnnotationConfigApplicationContext(Config.class);


    }
}

