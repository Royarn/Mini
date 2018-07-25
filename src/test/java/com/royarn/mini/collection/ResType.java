package com.royarn.mini.collection;

/**
 * @author lizq
 * @Description: ${todo}
 * @date 2018/7/12 9:38
 */
public enum ResType {

    platform(55);

    private int value;
    ResType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static ResType valuesOf(int val) {
        for (ResType resType : ResType.values()) {
            if (resType.value == val) {
                return resType;
            }
        }
        return null;
    }
}
