package com.royarn.mini.multiThread;

/**
 * @author lizq
 * @Description: ${todo}
 * @date 2018/7/23 9:46
 */
public class Worker2 extends Thread{

    private MyLatch latch;

    public Worker2(MyLatch latch) {
        this.latch = latch;
    }

    @Override
    public void run() {
        try {
            Thread.sleep((int) (Math.random() * 100));
            latch.countDown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
