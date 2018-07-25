package com.royarn.mini.task;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author lizq
 * @Description: ${todo}
 * @date 2018/7/24 16:10
 */
public class ScheduleException {

    static class TaskA implements Runnable {

        @Override
        public void run() {
            System.out.println("task A ... ");
        }
    }

    static class TaskB implements Runnable {

        @Override
        public void run() {
            System.out.println("task B ... ");
            throw new RuntimeException("task b has interupt ... ");
        }
    }

    public static void main(String[] args) {
        ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
        service.scheduleWithFixedDelay(new TaskA(), 1000, 1000, TimeUnit.MILLISECONDS);
        service.scheduleWithFixedDelay(new TaskB(), 100, 1000, TimeUnit.MILLISECONDS);
    }
}
