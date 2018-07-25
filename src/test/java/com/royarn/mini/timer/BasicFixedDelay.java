package com.royarn.mini.timer;

import java.util.Timer;
import java.util.TimerTask;

/**
 * @author lizq
 * @Description: ${todo}
 * @date 2018/7/24 14:33
 */
public class BasicFixedDelay {

    static class LongRunningTask extends TimerTask {

        @Override
        public void run() {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("long running finished ... ");
        }
    }

    static class FixedDelayTask extends TimerTask {

        @Override
        public void run() {
            System.out.println(System.currentTimeMillis());
        }
    }

    public static void main(String[] args) {
        Timer timer = new Timer();
        timer.schedule(new LongRunningTask(), 10);
        //timer.schedule(new FixedDelayTask(), 4000, 1000);
        timer.scheduleAtFixedRate(new FixedDelayTask(), 10 ,1000);
    }
}
