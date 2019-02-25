/***
 * 2019 年 2月 22 日
 * author 栾桂明
 * use 对数据结果中的数组进行学习
 */
public class ArrayOne<E> {
    //    这是一个记录数组中的元素个数的变量
    private int size;
    //     这是一个存放数据的数组
    private E[] data;

    /***
     * 初始化数组使用的构造器
     * @param capacity  该参数是说明初始化的数组的大小的一个参数
     */
    public ArrayOne(int capacity) {
        //初始化数组
        data = (E[]) new Object[capacity];
        //初始化标识数组中元素个数的变量
        size = 0;

    }

    /***
     * 默认创建一个容量为10的数组
     */
    public ArrayOne() {
        this(10);
    }

    /***
     * 返回数组中元素的个数的方法
     * @return ：返回的便是数组中的元素个数
     */
    public int getSize() {
        return size;
    }

    /***
     * 获取数组的容量
     * @return：返回的是数组中的全部的元素
     */
    public int getData() {
        return data.length;
    }

    /***
     * 判断数组是不是空的
     * @return 返回的是表示是否为空的一个Boolean数值
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /***
     * 在末尾处添加元素
     * @param e  待添加的元素
     */
    public void addLast(E e) {
        add(size, e);
    }

    /***
     * 在开始的位置添加元素
     * @param e  待添加的元素
     */
    public void addFrist(E e) {
        add(0, e);
    }

    /***
     * 删除指定的位置的元素
     * @param index  删除的元素的位置
     * @return 返回的是删除的元素
     */
    public E remove(int index) {
        if (index > size || index < 0) {
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

    /**
     * 删除地一个位置的元素
     *
     * @return
     */
    public E removeFrist() {
        return remove(0);

    }

    /***
     * 获取的是数组的容量
     * @return
     */
    public int getCapacity() {
        return data.length;
    }

    /***
     * 删除末尾的元素
     * @return
     */
    public E removeLast() {
        return remove(size - 1);

    }

    /***
     * 在指定的位置插入一个元素
     * @param index  插入元素的位置
     * @param e 要插入的元素
     */
    public void add(int index, E e) {
        // 判断是不是符合插入元素的条件
        if (index > size || index < 0) {
            throw new IllegalArgumentException("add fail require index >0 and index<size");
        }
        if (size == data.length) {
            //扩容的操作
            resize(size * 2);
        }
        // 为插入的元素腾位置
        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];

        }
        // 插入元素
        data[index] = e;
        size++;
    }

    /**
     * 数组进行扩容的方法
     *
     * @param newCapacity 扩容的大小
     */
    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    /***
     * 格式话字符串的方法
     * @return
     */
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

    /***
     * 判断数组中是否包含指定的元素
     * @param e  等待判断的元素
     * @return 判断的结果的返回数值
     */
    public boolean contain(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e))
                return true;
        }
        return false;
    }

    /***
     * 判断一个元素是否存在之后进行删除
     * @param e  要删除的元素
     */
    public void removeElement(E e) {
        int index = find(e);
        if (index == -1) {
            remove(index);
        }
    }

    /***
     * 判断数组中是不是包含指定的元素
     * @param e  等待判断的元素
     * @return 判断的结果的返回数值
     */
    public int find(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    /***
     * 设置索引位置的元素
     * @param index 设置索引的位置
     * @param e 设置索引的元素
     */
    public void set(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("add fail require index >0 and index<size");
        }
        data[index] = e;
    }

    /***
     * 获取索引位置的元素
     * @param index 获取索引的位置
     * @return 索引位置的元素
     */
    public E get(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("add fail require index >0 and index<size");
        }
        return data[index];
    }

    /***
     * 返回最后一个元素
     * @return
     */
    public E getLast() {
        return get(size - 1);
    }

    /***
     * 返回第一个元素
     * @return
     */
    public E getFrist() {
        return get(0);
    }
}

