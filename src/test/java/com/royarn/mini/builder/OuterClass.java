package com.royarn.mini.builder;

/**
 * @author lizq
 * @Description: ${todo}
 * @date 2018/7/9 10:45
 */

import com.alibaba.fastjson.JSON;

/**
 * 静态内部类：
 *  在类上使用static关键字只有一种情况，该类必须为内部静态类
 *  相比于普通内部类， 在内部类使用static关键字来修饰，可以视为外部类的静态成员变量
 *      非常典型的builder模式采用内部静态类
 *      普通内部类与外部类存在引用关系，所以在实例化普通内部类时需要先实例化外部类：如Outer out = new Outer(); Inner inner = out.new Inner();格式
 *      而静态内部类的使用不依赖外部类， 可以直接使用 Inner inner = new Outer.Inner();
 *      静态内部类不能访问外部类普通成员变量或者普通函数
 *      builder模式构建对象是一种替补方式
 */
public class OuterClass {

    private String name;
    private int age;

   public OuterClass(String name, int age) {
       this.age = age;
       this.name = name;
   }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public static class Builder {

        private String name;
        private int age;

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setAge(int age) {
            this.age = age;
            return this;
        }

        public OuterClass build() {
            return new OuterClass(name, age);
        }
    }

    public static void main(String[] args) {
        OuterClass outerClass = new Builder()
                .setName("royarn")
                .setAge(28)
                .build();
        System.out.println(JSON.toJSON(outerClass));
        int original = 100;
        System.out.println("数值： " + (original << 1));
    }
}
