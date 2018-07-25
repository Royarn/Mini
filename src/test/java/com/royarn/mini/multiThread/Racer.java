package com.royarn.mini.multiThread;

/**
 * @author lizq
 * @Description: ${todo}
 * @date 2018/7/20 16:46
 */
public class Racer extends Thread {

    FireFlag flag;

    public Racer(FireFlag fireFlag) {
        this.flag = fireFlag;
    }

    @Override
    public void run() {
        try {
            String task = flag.waitForFire();
            System.out.println("==============" + Thread.currentThread().getName() + "===================" + task);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
