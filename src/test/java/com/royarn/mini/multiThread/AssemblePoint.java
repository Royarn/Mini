package com.royarn.mini.multiThread;

/**
 * @author lizq
 * @Description: ${todo}
 * @date 2018/7/23 10:29
 */
public class AssemblePoint {

    private int count;

    public AssemblePoint(int count) {
        this.count = count;
    }

    public synchronized void await() throws InterruptedException {
        if (count > 0) {
            count--;
            if (count == 0) {
                notifyAll();
            } else {
                while (count != 0) {
                    wait();
                }
            }
        }
    }
}
