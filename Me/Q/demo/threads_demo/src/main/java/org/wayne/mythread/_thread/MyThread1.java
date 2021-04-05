package org.wayne.mythread._thread;

/**
 * @Description: 继承Thread 实现Runnable 来定义线程类
 * @author: LinWeiQi
 */
public class MyThread1 extends Thread {
    @Override
    public void run() {
        super.run();
        System.out.println("MyThread1 run priority=" + this.getPriority());
        MyThread2 thread2 = new MyThread2();
        thread2.start();
    }
}
