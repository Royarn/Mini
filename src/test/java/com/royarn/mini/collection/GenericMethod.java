package com.royarn.mini.collection;

import com.alibaba.fastjson.JSON;

/**
 * @author lizq
 * @Description: ${todo}
 * @date 2018/7/12 16:52
 */

public class GenericMethod {

    public static <T> Object delMethod(DynamicArray list, T ele) {
        if (list.size() == 0) {
            return "error";
        }
        for (int i=0;i< list.size();i++) {
            if (list.get(i).equals(ele)) {
                return "The element found in : " + i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
//        DynamicArray<String> dynamicArray = new DynamicArray<>(3);
//        dynamicArray.add("shadow");
//        dynamicArray.add("queen");
//        dynamicArray.add("blink");
//        DynamicArray<Integer> integerArray = new DynamicArray<>(3);
//        integerArray.add(10);
//        integerArray.add(100);
//        integerArray.add(1000);
//        DynamicArray<Number> numberArray = new DynamicArray<>();
//        integerArray.copyTo(numberArray);
//        for (int i=0;i<numberArray.size();i++) {
//            System.out.println(numberArray.get(i));
//        }

        DynamicArray<Number> numberArray = new DynamicArray<>();
        DynamicArray<Double> integerArray = new DynamicArray<>();
        integerArray.add(4.23);
        integerArray.add(40.67);
        numberArray.doubelStore(integerArray);
        for (int i=0;i<numberArray.size();i++) {
            System.out.println(numberArray.get(i));
        }
    }
}
