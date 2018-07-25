package com.royarn.mini.multiThread;

/**
 * @author lizq
 * @Description: ${todo}
 * @date 2018/7/23 10:27
 */

/**
 * 异步回调接口
 */
public interface Future<T> {
    T get() throws Exception;
}
