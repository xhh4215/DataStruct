/***
 * 对应于实现栈的功能的接口
 * @param <E>  栈中元素的类型
 */
public interface Stack<E> {
    // 获取栈中的元素的个数
    int getSize();

    // 判断栈是不是空的
    boolean isEmpty();

    // 进栈操作
    void push(E e);

    // 出栈操作
    E pop();

    // 查看栈定元素
    E peek();
}
