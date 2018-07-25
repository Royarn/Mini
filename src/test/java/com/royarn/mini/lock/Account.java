package com.royarn.mini.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author lizq
 * @Description: ${todo}
 * @date 2018/7/23 16:36
 */
public class Account {

    private Lock lock = new ReentrantLock();
    private volatile double money;

    public Account(double money) {
        this.money = money;
    }

    public void addMoney(double m) {
        try {
            lock.lock();
            money = money + m;
        } finally {
            lock.unlock();
        }
    }

    public void reduce(double m) {
        try {
            lock.lock();
            if (money > m ) {
                money = money - m;
            }
        } finally {
            lock.unlock();
        }
    }

    public double getMoney() {
        return money;
    }

    public void lock() {
        lock.lock();
    }

    public void unlock() {
        lock.unlock();
    }
}
