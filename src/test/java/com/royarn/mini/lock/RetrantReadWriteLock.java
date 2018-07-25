package com.royarn.mini.lock;

/**
 * @author lizq
 * @Description: ${todo}
 * @date 2018/7/24 16:43
 */

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 并发总结：
 *  线程状态：
 *      NEW RUNNABLE  BLOCKED  WAITED/TIMED_WAITING TERMINAL
 *   线程协作:
 *      1.synchronized与wait/notify机制
 *      2.显示锁与显示条件 （ReentrantLock、ReentrantReadWriteLock）
 *      两者都是阻塞式锁，即wait()或者await()都会使线程进入等待队列，满足条件后才会通过notify/notifyAll进行唤醒
 *      显示锁(lock)相较于synchronized是一种较为轻量级的锁，在一定程度避免了频繁的上下文切换，过多的消耗资源，使用了基于CAS原理实现，开销较小
 *   线程协作常用场景：
 *      1.生产者消费者模式
 *      2.同时发生 --多线程等待同一条件触发
 *      3.等待结束 --主线程的结束依赖于子线程（CountDownLatch）
 *      4.异步执行 --java提供了封装良好的工具更好的执行多线程任务 (Callable<T> --待执行任务     Future<T> --执行结果)
 *      5.集合点  --多个线程符合条件进行交互
 *
 *   java.util.concurrent包的基石
 *      原子变量和CAS
 *          原子变量： AtomicInteger、AtomicBoolean、AtomicReference
 *       CAS原理：
 *          本质依赖于内存可见性
 *          原子变量与常规变量的本质区别在于volatile来保证数据可见性
 *          阻塞式锁：ReentrantLock
 *              有两种实现：公平锁和非公平锁，内部都使用volatile变量，使用CAS原理来实现锁
 *              提供了非阻塞式锁：tryLock()
 *
 *   并发场景中的并发容器
 *      CopyOnWriteArray ---基于数组实现，在读操作时无锁，在有线程写时使用阻塞式锁来保证数据安全性
 *          适用于读远大于写的场景， 可很大程度提高并发量
 *      CopyOnWriteSet  --数据不允许重复，基于CopyOnWriteArray实现和CopyOnWriteArray作用相似
 *      ConcurrentSkipMap  --基于跳表实现  无阻塞式场景  （使用较少）
 *      ConcurrentSkipSet  --基于跳表实现
 *      上述两个基于跳表实现的单线程版本为： TreeMap和TreeSet 在并发环境下保证数据有序
 *      ConcurrentHashMap:   --HashMap的并发版本
 *          基本特性：
 *              1.基于分段存储，支持原子复合操作
 *              2.在一定程度支持并行读写，相比同步容器在迭代时不会抛出ConcurrentModifyException
 *              3.弱一致性
 *          分段存储：
 *              数据存放不在单一的table中，采用哈希值进行分段存储，不同段上的数据可以并发读写，提高并发能力
 *          弱一致性：
 *              主要体现在迭代数据时，发生了写操作，导致可能立即看到修改值，也可能看不到
 *    并发队列：
 *      在单线程环境中队列几乎不怎么使用， 但在多线程环境是极其重要的一种数据结构（如线程池的实现、等待队列）
 *      无锁非阻塞并发队列
 *          ConcurrentLinkedQueue --基于单链表实现  链表存储无上界，理论上可以无限挂载数据
 *          ConcurrentLinkedDequeue --基于双向链表实现
 *       普通阻塞队列
 *          ArrayBlockingQueue --基于数组实现（有容量限制  在生产着/消费者模式中使用）
 *          LinkedBlockingQueue --基于链表实现（无容量限制  如在线程池的实现中使用LinkedBlockingQueue）
 *       优先级阻塞队列
 *          PriorityBlockingQueue --基于堆的实现 （无容量上限 可以调度线程执行的优先级，基于权重来存储数据）
 *        延迟阻塞队列
 *          DelayQueue  --基于堆实现 （无容量上限  基于最长等待时间调度线程执行）
 *        其他阻塞队列
 *          SynchronousQueue --不能存储数据  --在线程池的实现中，只要有空闲线程，即执行
 *   异步执行服务框架
 *      Callable<T>  任务单元
 *      Future<T>  执行结果单元
 *      Executors类  提供基于多线程的实现 （封装线程池）
 *
 *   同步和协作常用工具类
 *      ReentrantReadWriteLock  读写锁  读-读操作可以并行执行，只有涉及读-写 或者写-写时再会同步
 *                 在高并发场景下，可以使用读写锁来提高并发能力
 *      CountDownLatch 程序计数器
 *          1.用来协调主线程和子线程的执行  只有当所有子线程结束时主线程才会停止  (如在nginx服务器中就是典型的 work-master模型)
 *          2.同时执行  满足某一条件，多个线程同时执行
 *      Semaphre  信号量   共享锁   主要用来控制资源访问的并发数 (tomcat的并发数限制)
 *      CyclicBarrier 集合点 可以重复利用的一种协作
 *
 *
 */
public class RetrantReadWriteLock {

    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    private Lock readLock = lock.readLock();
    private Lock writeLock = lock.writeLock();

    public void write() {
        try {
            writeLock.lock();
            System.out.println("thread is writing ... ");
        } finally {
            writeLock.unlock();
        }
    }

    public void read() {
        try {
            readLock.lock();
            System.out.println("thread is reading ... ");
        } finally {
            readLock.unlock();
        }
    }
}

