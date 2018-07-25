package com.royarn.mini.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author lizq
 * @Description: ${todo}
 * @date 2018/7/23 19:49
 */
public class WaitThread extends Thread{

    private volatile boolean fire = false;
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    @Override
    public void run() {
        try {
            lock.lock();
            while (!fire) {
                condition.await();
            }
            System.out.println("sub thread is running ... ");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void fire() {
        try {
            lock.lock();
            fire = true;
            condition.signal();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        WaitThread thread = new WaitThread();
        thread.start();
        Thread.sleep(10000);
        System.out.println("fire ... ");
        thread.fire();
    }
}
