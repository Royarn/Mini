package com.royarn.mini.multiThread;

import java.util.concurrent.CountDownLatch;

/**
 * @author lizq
 * @Description: ${todo}
 * @date 2018/7/25 10:19
 */
public class MasterWorkDemo {

    static CountDownLatch latch = new CountDownLatch(10);

    static class Worker extends Thread {

        @Override
        public void run() {
            try {
                Thread.sleep(2000);
                System.out.println(Thread.currentThread().getName() + " is shutdown .. ");
                latch.countDown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Worker[] workers = new Worker[10];
        for (int i=0;i<workers.length;i++) {
            workers[i] = new Worker();
            workers[i].start();
        }

        latch.await();
        System.out.println("all threads is shutdown ... ");
    }
}
