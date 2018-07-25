package com.royarn.mini.generic;

import com.royarn.mini.collection.DynamicArray;

/**
 * @author lizq
 * @Description: ${todo}
 * @date 2018/7/12 18:41
 */
public class MegerGeneric {

    public static void main(String[] args) {
        DynamicArray<Number> numberArray = new DynamicArray<>();
        DynamicArray<Integer> integerArray = new DynamicArray<>();
        DynamicArray<Double> doubleArray = new DynamicArray<>();
        integerArray.add(34);
        doubleArray.add(23.0);
        numberArray.add(100);
        numberArray.addAll(integerArray);
        numberArray.addAll(doubleArray);
        System.out.println(numberArray.size());
    }
}
