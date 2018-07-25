package com.royarn.mini.atomic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author lizq
 * @Description: ${todo}
 * @date 2018/7/23 11:51
 */
public class AtomicIntegerDemo {

    private static AtomicInteger counter = new AtomicInteger();

    static class Visitor extends Thread {
        @Override
        public void run() {
            for(int i=0;i<1000;i++) {
                counter.incrementAndGet();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        int num = 1000;
        Thread[] threads = new Thread[num];
        for (int i=0;i<num;i++) {
            threads[i] = new Visitor();
            threads[i].start();
        }

        for (int i=0;i<num;i++) {
            threads[i].join();
        }
        System.out.println(counter.get());
    }
}
