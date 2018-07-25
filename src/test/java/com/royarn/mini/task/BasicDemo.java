package com.royarn.mini.task;

import java.util.Random;
import java.util.concurrent.*;

/**
 * @author lizq
 * @Description: ${todo}
 * @date 2018/7/24 10:38
 */
public class BasicDemo {

    static class Task implements Callable<Integer> {

        @Override
        public Integer call() throws Exception {
            int sleepSeconds = new Random().nextInt(1000);
            Thread.sleep(10000);
            return sleepSeconds;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<Integer> result = executorService.submit(new Task());
        //模拟执行其他任务
        try {
            System.out.println(result.get());
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        executorService.shutdown();
    }
}