package com.royarn.mini.multiThread;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author lizq
 * @Description: ${todo}
 * @date 2018/7/20 14:01
 */
public class MyBlockingQueue<E> {

    private Queue<E> arrayDeque;
    private int limit;

    public MyBlockingQueue(int limit) {
        this.limit = limit;
        arrayDeque = new ArrayDeque<>(limit);
    }

    public synchronized E put(E e) {
        if (arrayDeque.size() == limit) {
            try {
                wait();
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
        }
        arrayDeque.add(e);
        notifyAll();
        return e;
    }

    public synchronized E take() {
        if (arrayDeque.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        E e = arrayDeque.poll();
        notifyAll();
        return e;
    }
}
