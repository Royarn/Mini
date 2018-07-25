package com.royarn.mini.collection;

import java.util.Arrays;

/**
 * @author lizq
 * @Description: ${todo}
 * @date 2018/7/11 21:33
 */

/**
 * 泛型特性总结
 *  泛型从字面理解就是广泛的类型
 *  在容器类的设计中大量运用了泛型设计， 其旨在专注设计算法， 分离了数据结构
 *  泛型本质是： 将通用算法应用于所有类型元素（即Object）
 *  在泛型未出现之前 即JDK1.5之前，所有的数据元素类型均为Object，在实际应用中会出现错误类型强制转换（运行时异常，在存储或者转换过程中出现不同类型元素）
 *  泛型的设计目的本质是在编译层面的一种优化，主要作用是改进JDK1.5之前的一些诸如类型转换的问题提前到编译时即可检查出来
 *  泛型主要解决两点：
 *      1.编译时可根据实例化存储声明数据类型时进行检查并提示错误 形如List<String> list = new ArrayList(); Integer a = (Interger) list.get(index);
 *      2.更好的可读性
 *   泛型使用规则：
 *      可作用于类、方法
 *      泛型支持通配符 形如<T extends E>  即表示数据类型T必须是E的接口实现或者子类
 *          <? extends E> 即表示可以是E的任意类型子类或者接口或者抽象类
 *      泛型方法和泛型类在声明时最显著的区别：
 *          泛型方法声明规则： public <T extends E> T method(T data) 或者： public <T> T method(T data) 即类型声明与参数一致
 *          泛型类的方法声明： public <T extends E> void method(SomeClass<T> data) 或者 public <T> void method(SomeClass<T> data) 声明类型于数据实际类型一直，并且返回值必须为指定实际类型
 *      在泛型类中，泛型数据T若存在上界，则可以使用通配符来声明类型
 *          一般声明：public <T extends E> void method(SomeClass<T> data)
 *          通配符声明：public void method(SomeClass<?> data) 两者等价
 */
public class DynamicArray<E> {

    private static final int DEFAULT_CAPACITY = 10;
    private Object[] elementData;
    private int size;

    //默认初始化容量
    public DynamicArray() {
        elementData = new Object[DEFAULT_CAPACITY];
    }

    //定制初始化容量
    public DynamicArray(int capacity) {
        elementData = new Object[capacity];
    }

    //提供操作API
    public <E> boolean add(E e) {
        //容量是否满足
        ensureCapacity(size + 1);
        elementData[size++] = e;
        return true;
    }

    private void ensureCapacity(int miniCapacity) {
        int oldCapacity = elementData.length;
        int newLength = oldCapacity + (oldCapacity >> 1);
        if (miniCapacity - oldCapacity >= 0) {
            //进行扩容
            elementData = Arrays.copyOf(elementData, newLength);
        }
    }

    public int size() {
        return size;
    }

    public E get(int index) {
        return (E) elementData[index];
    }

    //批量添加元素
    public <T extends E> boolean addAll(DynamicArray<T> list) {
        if (list.size == 0) {
            return false;
        }
        for (int i=0;i<list.size();i++) {
            add(get(i));
        }
        return true;
    }

    //第二种实现
    public boolean addList(DynamicArray<? extends E> list) {
        if (list.size == 0) {
            return false;
        }
        for (int i=0;i<list.size();i++) {
            add(get(i));
        }
        return true;
    }

    //泛型方法
    public <X extends Comparable<X>> X compare(X[] data) {
        if (data.length == 0) return null;
        X max = data[0];
        for (int i=0;i<data.length;i++) {
            if (data[i].compareTo(max) > 0) {
                max = data[i];
            }
        }
        return max;
    }

    public void external(DynamicArray<?> dynamicArray) {

    }

    public <D> void external2(DynamicArray<D> dDynamicArray) {

    }

    public <W> W med(DynamicArray<W> dynamicArray) {
        return dynamicArray.get(0);
    }

    //向父类中灌入数据方式
    public void copyTo(DynamicArray<? super E> dynamicArray) {
        for (int i=0;i<size;i++) {
            dynamicArray.add(get(i));
        }
    }

    public <T> T normal(DynamicArray<T> list) {
        return list.get(0);
    }

    /**
     * 高级泛型示例
     *  P类型数据满足以下几点：
     *      1.P数据类型必须是Comparable接口实现类或者继承Comparable的接口
     *      2.Compare的compareTo方法实现不在P类型中，P类型数据要实现比较则需要在相关父类中实现，即实现compareTo的复用
     */
    public <P extends Comparable<? super P>> void sort(DynamicArray<P> list) {
    }

    public static <V> V test(V data) {
        return data;
    }

    public <I extends E> void doubelStore(DynamicArray<I> list) {
        for (int i=0;i<list.size();i++) {
           add(list.get(i));
        }
    }
}
