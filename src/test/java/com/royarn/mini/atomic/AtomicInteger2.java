package com.royarn.mini.atomic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author lizq
 * @Description: ${todo}
 * @date 2018/7/23 14:00
 */

/**
 * AtomicInteger类型数据与Integer基本一致
 *  区别在于多线程环境下，对数据进行操作的安全性保护
 *  Integer在单线程环境下计算是安全的， 而在多线程环境下不安全
 */
public class AtomicInteger2 {

    static AtomicInteger value = new AtomicInteger();
    static Integer intValue = new Integer(0);

    static class Counter extends Thread {

        @Override
        public void run() {
            for (int i=0;i<1000;i++) {
                value.incrementAndGet();
                intValue++;
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[10];
        for (int i=0;i<threads.length;i++) {
            threads[i] = new Counter();
            threads[i].start();
        }

        for (int i=0;i<threads.length;i++) {
            threads[i].join();
        }
        //System.out.println(value.get());
        System.out.println(intValue.intValue());
    }
}
