package com.lxf.study.simplecase.datastructure;

import java.util.Arrays;
import java.util.Iterator;
import java.util.function.Consumer;
import java.util.stream.Stream;

/**
 * 动态数组-数组实现
 */
public class DynamicArray<E> implements Iterable<E> {

    private Object[] array = {};

    // 逻辑大小
    private int size = 0;


    // 容量
    private int capacity = 7;

    public DynamicArray() {
        array = new Object[capacity];
    }

    public DynamicArray(int capacity) {
        this.array = new Object[capacity];

        this.capacity = capacity;
    }

    /**
     * 添加元素
     */
    public void add(E e) {
        grow();
        array[size] = e;
        size++;
    }

    /**
     * 在指定索引处插入元素
     *
     * @param index 索引
     * @param e     元素
     */
    public void addAt(int index, E e) {
        grow();
        if (index >= 0 && index < size) {
            System.arraycopy(array, index, array, index + 1, size - index);
        } else {
            throw new RuntimeException("索引越界");
        }
        array[index] = e;
        size++;
    }


    /**
     * 获取指定索引的元素
     *
     * @param index 索引
     * @return 指定索引位置的元素
     */
    @SuppressWarnings("unchecked")
    public E get(int index) {
        if (index >= 0 && index < size) {
            return (E) array[index];
        } else {
            throw new RuntimeException("索引越界");
        }
    }

    /**
     * 删除一个元素
     *
     * @param e 要删除的元素
     */
    public boolean remove(E e) {
        for (int i = 0; i < size; i++) {
            if (e == array[i]) {
                System.arraycopy(array, i + 1, array, i, size - i - 1);
                size--;
                return true;
            }
        }
        return false;
    }

    /**
     * 获取迭代器
     *
     * @return 迭代器
     */
    @Override
    @SuppressWarnings("unchecked")
    public Iterator<E> iterator() {
        return new Iterator<>() {


            int i = 0;

            @Override
            public boolean hasNext() {
                return i < size;
            }

            // 返回当前元素,并移动到下一个元素
            @Override
            public E next() {
                E e = (E) array[i];
                i++;
                return e;
            }
        };
    }

    @SuppressWarnings("unchecked")
    public void foreach(Consumer<E> action) {
        for (int i = 0; i < size; i++) {
            action.accept((E) array[i]);
        }
    }

    @SuppressWarnings("unchecked")
    public Stream<E> stream() {
        Object[] arr = Arrays.copyOfRange(array, 0, size);
        return (Stream<E>) Stream.of(arr);
    }

    /**
     * 扩容
     */
    private void grow() {
        // 扩容检查
        if (size == capacity) {
            // 扩容为之前的1.5倍
            capacity = capacity / 2 + capacity; // 扩容为之前的1.5倍
            Object[] newArray = new Object[capacity];
            System.arraycopy(array, 0, newArray, 0, size);
            array = newArray;
        }
    }

    @Override
    public String toString() {
        // 按区间拷贝数组
        Object[] arr = Arrays.copyOfRange(array, 0, size);
        return Arrays.toString(arr);
    }

    public static void main(String[] args) {
        DynamicArray<Integer> list = new DynamicArray<>(3);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        /*for (Integer i : list) {
            System.out.println(i);
        }*/
        list.stream().forEach(System.out::println);
        System.out.println(list);
    }

}
