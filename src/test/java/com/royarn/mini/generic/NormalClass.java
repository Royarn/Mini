package com.royarn.mini.generic;

/**
 * @author lizq
 * @Description: ${todo}
 * @date 2018/7/13 9:23
 */
public class NormalClass {

    /**
     * define the generic method
     */
    public static  <T extends Number> void printInfo(T data) {
        System.out.println(data);
    }

    public static <T extends Comparable<T>> T findMax(T[] arr) {
        T max = arr[0];
        for (int i=0;i<arr.length;i++) {
            if (arr[i].compareTo(max) > 0) {
                max = arr[i];
            }
        }
        return max;
    }

//    public static void main(String[] args) {
//        NormalClass.printInfo(10);
//        NormalClass.printInfo(10.0);
//        System.out.println(NormalClass.findMax(new Integer[] {1,5,3,23,10}));
//    }

    static boolean foo(char c) {
        System.out.println(c);
        return true;
    }

    public static void main(String[] args) {
        int i=0;
       for (foo('A');foo('B') && i<2; foo('C')) {
           i++;
           foo('D');
       }
    }
}