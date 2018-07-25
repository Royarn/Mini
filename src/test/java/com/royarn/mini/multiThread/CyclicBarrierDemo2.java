package com.royarn.mini.multiThread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author lizq
 * @Description: ${todo}
 * @date 2018/7/25 10:46
 */
public class CyclicBarrierDemo2 {

    static CyclicBarrier cyclicBarrier;

    static class Tourist extends Thread {

        @Override
        public void run() {
            try {
                //模拟各自运行的程序
                Thread.sleep((int) (Math.random() * 1000));
                //集合点A
                cyclicBarrier.await();
                System.out.println(this.getName() + " arrived A " + System.currentTimeMillis());

                //集合后模拟再各自独立执行
                Thread.sleep((int) (Math.random() * 1000));
                //集合点B
                cyclicBarrier.await();
                System.out.println(this.getName() + " arrived B " + System.currentTimeMillis());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Thread[] threads = new Thread[10];
        cyclicBarrier = new CyclicBarrier(10, new Runnable() {
            @Override
            public void run() {
                System.out.println("all arrived " + System.currentTimeMillis() + " executed by " + Thread.currentThread().getName());
            }
        });

        for (int i=0;i<threads.length;i++) {
            threads[i] = new Tourist();
            threads[i].start();
        }
    }
}
