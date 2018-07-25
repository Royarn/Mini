package com.royarn.mini.multiThread;

/**
 * @author lizq
 * @Description: ${todo}
 * @date 2018/7/20 17:04
 */

//线程计数器  --用来实现类似join功能
public class MyCountDownLatch {

    private int count;

    public MyCountDownLatch(int count) {
        this.count = count;
    }

    public synchronized void await() throws InterruptedException {
        while (count > 0) {
            wait();
        }
    }

    public synchronized void countDown() {
        count--;
        while (count <= 0) {
            notifyAll();
        }
    }
}
