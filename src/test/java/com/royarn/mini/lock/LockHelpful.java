package com.royarn.mini.lock;

import java.util.concurrent.locks.LockSupport;

/**
 * @author lizq
 * @Description: ${todo}
 * @date 2018/7/23 17:37
 */
public class LockHelpful {

    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread() {
            @Override
            public void run() {
                LockSupport.park();
                System.out.println("sub thread exit");
            }
        };
        t.start();
        Thread.sleep(10000);
        LockSupport.unpark(t);
        System.out.println("thread start ... ");
    }
}
