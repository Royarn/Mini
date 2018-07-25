package com.royarn.mini.multiThread;

/**
 * @author lizq
 * @Description: ${todo}
 * @date 2018/7/20 16:42
 */
public class FireFlag {

    private volatile boolean fired = false;

    public synchronized String waitForFire() throws InterruptedException {
        if (!fired) {
            System.out.println("===============" + Thread.currentThread().getName() + "=============" + "is ready ... ");
            wait();
        }
        return "running ... ";
    }

    public synchronized void fire() {
        this.fired = true;
        notifyAll();
    }
}
