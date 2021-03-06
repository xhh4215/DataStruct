package com.company;

/***
 * 自己定制的动态的数组
 */
public class Array<E> {
    private E[] data;
    private int size;

    public Array(int capacity) {
        /**
         * @param  capacity 数据的容量参数
         */
        data = (E[]) new Object[capacity];
    }

    /**
     * 默认的构造器
     */
    public Array() {
        this(10);
    }

    //获取数组中的元素的个数
    public int getSize() {
        return size;
    }

    //获取数组的容量
    public int getData() {
        return data.length;
    }

    //判断数组是不是空的
    public boolean isEmpty() {
        return size == 0;
    }

    // 向数组末尾添加一个数据
    public void addLast(E e) {
        add(size, e);

    }

    // 在数组的头位置添加元素
    public void addFrist(E e) {
        add(0, e);
    }

    // 向index的位置添加数据
    public void add(int index, E e) {
        if (size == data.length) {
            throw new IllegalArgumentException("add fail Array is full");

        } else if (index > size || index < 0) {
            throw new IllegalArgumentException("add fail require index >0 and index<size");
        }
        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = e;
        size++;
    }

    // 删除指定位置的元素
    public E remove(int index) {
        if (index < size || index < 0) {
            throw new IllegalArgumentException("add fail require index >0 and index<size");
        }
        E ret = data[index];
        for (int i = index + 1; i < size; i--) {
            data[i - 1] = data[i];
        }
        size--;
        data[size] = null;
        return ret;
    }

    public E removeFrist() {
        return remove(0);
    }

    public E removeLast() {
        return remove(size - 1);
    }

    // 判断是不是存在一个元素 存在的话就删除
    public void removeElement(E e) {
        int index = find(e);
        if (index != -1) {
            remove(index);
        }
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array:size =  %d,capacity = %d\n", size
                , data.length));
        res.append("[");
        for (int i = 0; i < size; i++) {
            res.append(data[i]);
            if (i != size - 1) {
                res.append(", ");
            }
        }
        res.append("]");
        return res.toString();
    }

    public boolean contains(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i] .equals(e)) ;
            return true;
        }
        return false;
    }

    public int find(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i] .equals(e)) {
                return i;
            }
        }
        return -1;
    }

    // 设置索引位置的元素
    public void set(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("add fail require index >0 and index<size");
        }
        data[index] = e;
    }

    // 获取索引位置元素
    public E get(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("add fail require index >0 and index<size");
        }
        return data[index];
    }
}
