package com.royarn.mini.multiThread;

/**
 * @author lizq
 * @Description: ${todo}
 * @date 2018/7/20 14:21
 */
public class KafkaTest {

    public static void main(String[] args) throws InterruptedException {
        /**
         *  生产者消费者模式
         *  共享变量 --即共享资源
         */
        /**MyBlockingQueue<String> queue = new MyBlockingQueue<>(10);
        //生产者
        Producer producer = new Producer(queue);
        //消费者
        Consumer consumer = new Consumer(queue);
        Thread producerThread = new Thread(producer);
        Thread consumerThread = new Thread(consumer);
        producerThread.start();
        consumerThread.start();*/

        /**
         * 主程序释放信号 --子程序监听
         */
        /**FireFlag fireFlag = new FireFlag();
        for (int i=0;i<10;i++) {
            Thread thread = new Racer(fireFlag);
            thread.start();
        }
        try {
            Thread.sleep(5000);
            //主程序释放信号
            fireFlag.fire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/

        /**
         *  在多线程编程中 --在JDK1.6的并发包中增加了CountDownLatch类
         *  用来控制线程间的协作
         *  监视子程序的个数，初始值为子程序的总数，每当一个子程序停止，计数器就-1
         *  程序计数器
         *  Nginx服务器就是这样的工作模型
         *  分为master thread 和 worker thread
         */
        /**MyCountDownLatch countDownLatch = new MyCountDownLatch(10);
        Worker[] workers = new Worker[10];
        for (int i=0;i<10;i++) {
           workers[i] = new Worker(countDownLatch);
           workers[i].start();
        }

        //主线程要等待子线程执行完毕再结束
        countDownLatch.await();
        System.out.println("all threads is stopped ");*/

        int workNum = 10;
        MyLatch latch = new MyLatch(100);
        Worker2[] worker2 = new Worker2[workNum];
        for (int i=0;i<workNum;i++) {
            worker2[i] = new Worker2(latch);
            worker2[i].start();
        }

        latch.await();
        System.out.println("all Threads has been stopped ... ");
    }
}