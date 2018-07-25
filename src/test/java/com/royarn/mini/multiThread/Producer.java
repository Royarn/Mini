package com.royarn.mini.multiThread;


import java.util.UUID;

/**
 * @author lizq
 * @Description: ${todo}
 * @date 2018/7/20 14:09
 */
public class Producer implements Runnable{

    private MyBlockingQueue<String> queue = null;

    public Producer(MyBlockingQueue<String> myBlockingQueue) {
        this.queue = myBlockingQueue;
    }

    @Override
    public void run() {
        try {
            while (true) {
                String task = UUID.randomUUID().toString();
                queue.put(task);
                System.out.println("=========生产者推送数据=============" + task);
                Thread.sleep((int) (Math.random() * 100));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
