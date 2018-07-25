package com.royarn.mini.lock;

import java.util.concurrent.Semaphore;

/**
 * @author lizq
 * @Description: ${todo}
 * @date 2018/7/25 9:55
 */
public class AccessControlService {

    private Semaphore semaphore = new Semaphore(10);
    public boolean login(String name) {
        if (!semaphore.tryAcquire()) {
            try {
                throw new Exception("reject request ... ");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + " login success ... ");
        return true;
    }

    public void logout(String name) {
        semaphore.release();
    }
}
