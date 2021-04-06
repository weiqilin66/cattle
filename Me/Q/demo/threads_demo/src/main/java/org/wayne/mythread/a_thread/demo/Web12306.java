package org.wayne.mythread.a_thread.demo;

/**
 * @TODO: 模拟抢票,网络延迟
 * 一份资源,多人共享 = 并发
 * @author: lwq
 */
public class Web12306 implements Runnable {
    private int num = 50;
    @Override
    public void run() {
        while (true){
            if (num<0) {
                break;
            }
            // 模拟网络延迟, 出现了负数情况
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"-->余票:" + num--);
        }
    }


    public static void main(String[] args) {
        // 一份资源(单实例)
        // 或者使用多实例但是票资源num为static只有一份实例变量
        final Web12306 obj = new Web12306();
        // 多线程强
        new Thread(obj,"线程1").start();
        new Thread(obj,"线程2").start();
        new Thread(obj,"线程3").start();
    }
}
