package org.proxy.jdk.demo;

/**
 * @TODO: 真实服务对象
 * @author: lwq
 */
public class HelloServiceImpl implements HelloService {
    @Override
    public void sayHello(String msg) {
        System.out.printf("hello:%s\n",msg);
    }
}
