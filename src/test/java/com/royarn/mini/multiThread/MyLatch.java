package com.royarn.mini.multiThread;

/**
 * @author lizq
 * @Description: ${todo}
 * @date 2018/7/23 9:44
 */
public class MyLatch {

    private int count;

    public MyLatch(int count) {
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
