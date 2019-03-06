/***
 * 基于动态数组实现的栈
 * @param <E> 栈内部存放的数据类型
 */
public class ArrayStack<E> implements Stack<E> {
    // 用于动态处理数据的
    private Array<E> array;

    // 创建指定的个数的数据栈
    public ArrayStack(int capacity) {
        array = new Array<>(capacity);
    }

    //默认的创建数据栈的构造器
    public ArrayStack() {
        array = new Array<>();
    }

    //获取栈中的元素个数
    @Override
    public int getSize() {
        return array.getSize();
    }

    //判断栈是不是空的
    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    //获取栈的容量
    public int getCapacity() {
        return array.getCapacity();
    }

    //进栈的操作
    @Override
    public void push(E e) {
        array.addLast(e);
    }

    //出栈的操作
    @Override
    public E pop() {
        return array.removeLast();

    }

    //查看栈顶元素
    @Override
    public E peek() {
        return array.getLast();
    }

    /***
     * 显示的遍历栈中的元素，并显示出来
     * @return
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Stack:");
        builder.append("[");
        for (int i = 0; i < array.getSize(); i++) {
            builder.append(array.get(i));
            if (i != array.getSize() - 1) {
                builder.append(", ");
            }
        }
        builder.append("] top");

        return builder.toString();
    }
}
