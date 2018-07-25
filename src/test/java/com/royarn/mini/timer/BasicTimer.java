package com.royarn.mini.timer;

import java.util.Timer;
import java.util.TimerTask;

/**
 * @author lizq
 * @Description: ${todo}
 * @date 2018/7/24 14:28
 */

/**
 * jdk原生的定时任务
 *  基于固定延时执行的任务
 */
public class BasicTimer {

    static class DelayTask extends TimerTask {

        @Override
        public void run() {
            System.out.println("delay task ... ");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Timer timer = new Timer();
        timer.schedule(new DelayTask(), 1000);
        Thread.sleep(2000);
        timer.cancel();
    }
}
