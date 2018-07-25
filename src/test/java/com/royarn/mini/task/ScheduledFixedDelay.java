package com.royarn.mini.task;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author lizq
 * @Description: ${todo}
 * @date 2018/7/24 16:01
 */
public class ScheduledFixedDelay {

    static class LongRunningTask implements Runnable {

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

    static class FixedDelay implements Runnable {

        @Override
        public void run() {
            System.out.println(System.currentTimeMillis());
        }
    }

    public static void main(String[] args) {
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(10);
        executorService.schedule(new LongRunningTask(), 10, TimeUnit.MILLISECONDS);
        executorService.scheduleWithFixedDelay(new FixedDelay(), 100, 1000, TimeUnit.MILLISECONDS);
    }
}
