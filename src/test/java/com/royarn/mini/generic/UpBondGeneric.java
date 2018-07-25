package com.royarn.mini.generic;

import com.alibaba.fastjson.JSON;

/**
 * @author lizq
 * @Description: ${todo}
 * @date 2018/7/12 18:02
 */

/**
 * 泛型上界
 * @param <K>
 * @param <V>
 */
public class UpBondGeneric<K extends Number, V extends Number> {

    private K first;
    private V second;

    public K getFirst() {
        return first;
    }

    public void setFirst(K first) {
        this.first = first;
    }

    public V getSecond() {
        return second;
    }

    public void setSecond(V second) {
        this.second = second;
    }

    public static void main(String[] args) {
        UpBondGeneric<Integer, Byte> generic = new UpBondGeneric<>();
        generic.setFirst(1524);
        generic.setSecond(new Integer(12).byteValue());
        System.out.println(JSON.toJSON(generic));
    }
}
