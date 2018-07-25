package com.royarn.mini.multiThread;

/**
 * @author lizq
 * @Description: ${todo}
 * @date 2018/7/20 17:21
 */
public class Worker extends Thread{

    private MyCountDownLatch countDownLatch;

    public Worker(MyCountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        try {
            System.out.println("=============" + Thread.currentThread().getName() + "============ " + "is stopping ... ");
            Thread.sleep(2000);
            this.countDownLatch.countDown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
