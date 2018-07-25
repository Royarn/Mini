package com.royarn.mini.multiThread;

import java.util.concurrent.CountDownLatch;

/**
 * @author lizq
 * @Description: ${todo}
 * @date 2018/7/25 10:11
 */
public class RacerWithCountDownLatch {

    static CountDownLatch latch = new CountDownLatch(1);

    static class Racer extends Thread {

        @Override
        public void run() {
            try {
                latch.await();
                Thread.sleep(2000);
                System.out.println(Thread.currentThread().getName() + " is running ... ");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Thread[] threads = new Thread[100];
        for (int i=0;i<threads.length;i++) {
            threads[i] = new Racer();
            threads[i].start();
        }
        System.out.println("ready ! go ");
        latch.countDown();
    }
}
