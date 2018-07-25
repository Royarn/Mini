package com.royarn.mini.atomic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author lizq
 * @Description: ${todo}
 * @date 2018/7/23 14:28
 */

/**
 * 阻塞锁
 *  当lock时，如果更新不成功，则代表值被变更
 */
public class MyLock {

    private AtomicInteger value = new AtomicInteger();

    public void lock() {
        while (!value.compareAndSet(0, 1)) {
            Thread.yield();
        }
    }

    public void unlock() {
        value.compareAndSet(1, 0);
    }
}
