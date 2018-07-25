package com.royarn.mini.multiThread;

/**
 * @author lizq
 * @Description: ${todo}
 * @date 2018/7/23 10:26
 */

/**
 * 子任务接口
 * @param <T>
 */
public interface Callable<T> {
    T call() throws Exception;
}
