package com.royarn.mini.multiThread;


/**
 * @author lizq
 * @Description: ${todo}
 * @date 2018/7/20 14:17
 */
public class Consumer implements Runnable {

    private MyBlockingQueue<String> queue = null;

    public Consumer(MyBlockingQueue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            while (true) {
                String task = queue.take();
                System.out.println("==========消费者拉取数据============" + task);
                Thread.sleep((int) (Math.random() * 100));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
