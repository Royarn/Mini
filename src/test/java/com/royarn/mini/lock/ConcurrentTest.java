package com.royarn.mini.lock;

import java.util.concurrent.*;

/**
 * @author lizq
 * @Description: ${todo}
 * @date 2018/7/25 10:00
 */
public class ConcurrentTest {

    static AccessControlService service = new AccessControlService();

    static class Task implements Runnable {

        @Override
        public void run() {
            service.login(Thread.currentThread().getName());
        }
    }

    public static void main(String[] args) {
        ScheduledExecutorService service = Executors.newScheduledThreadPool(100);
        service.scheduleWithFixedDelay(new Task(), 100, 2000, TimeUnit.MILLISECONDS);
    }
}
