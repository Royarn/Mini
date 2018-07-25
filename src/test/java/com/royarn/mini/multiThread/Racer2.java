package com.royarn.mini.multiThread;

/**
 * @author lizq
 * @Description: ${todo}
 * @date 2018/7/20 18:2
 */
public class Racer2 {

    private MyCountDownLatch countDownLatch;

    public Racer2(MyCountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    public synchronized void waitForFire() {
//        while (countDownLatch.)
    }
}
