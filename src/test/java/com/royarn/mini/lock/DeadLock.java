package com.royarn.mini.lock;

import java.util.Random;

/**
 * @author lizq
 * @Description: ${todo}
 * @date 2018/7/23 16:40
 */
public class DeadLock {

    public static void transfer(Account from, Account to, double money) {
        try {
            from.lock();
            try {
                to.lock();
                if (from.getMoney() >= money) {
                    from.reduce(money);
                    to.addMoney(money);
                }
            } finally {
                to.unlock();
            }
        } finally {
            from.unlock();
        }
    }

    public static void main(String[] args) {
        int acountNum = 100;
        Account[] accounts = new Account[acountNum];
        for (int i=0;i<accounts.length;i++) {
            accounts[i] = new Account(new Random().nextInt(10000));
        }
        int threadNum = 100;
        Thread[] threads = new Thread[threadNum];
        for (int i=0;i<threadNum;i++) {
            threads[i] = new Thread() {
                @Override
                public void run() {
                    int loopNum = 100;
                    for (int k=0;k<loopNum;k++) {
                        int i = new Random().nextInt(acountNum);
                        int j = new Random().nextInt(acountNum);
                        int money = new Random().nextInt(10);
                        if (i != j) {
                            transfer(accounts[i], accounts[j], money);
                        }
                    }
                }
            };
            threads[i].start();
        }
    }
}
