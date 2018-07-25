package com.royarn.mini.multiThread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author lizq
 * @Description: ${todo}
 * @date 2018/7/25 10:36
 */
public class CyclicBarrierDemo {

    static CyclicBarrier barrier = new CyclicBarrier(30);

    static class Tourist extends Thread {

        @Override
        public void run() {
            try {
                barrier.await();
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName() + " has arrived ... ");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Thread[] threads = new Thread[30];
        for (int i=0;i<threads.length;i++) {
            threads[i] = new Tourist();
            threads[i].start();
        }
        System.out.println("all thread is finished ... ");
    }
}
