/***
 * @author 栾桂明
 * @use 基于动态数组实现的队列
 * @time 2019年 3月7号
 * @param <E> 动态数组支持的数据类型
 */
public class ArrayQueue<E> implements Queue<E> {
    //声明一个动态数组变量
    private Array<E> array;

    /***
     * 一个可以初始化指定数量的元素的构造器
     * @param capacity
     */
    public ArrayQueue(int capacity) {
        array = new Array<>(capacity);

    }

    /***
     * 一个没有参数的默认构造器
     */
    public ArrayQueue() {
        array = new Array<>();
    }

    /**
     * 获取队列中的元素数量
     *
     * @return
     */
    @Override
    public int getSize() {
        return array.getSize();
    }

    /***
     * 获取队列中的第一个元素
     * @return
     */
    @Override
    public E getFront() {
        return array.getFrist();
    }

    /***
     * 出队的操作
     * @return
     */
    @Override
    public E dequeue() {
        return array.removeFrist();
    }

    /***
     * 入队的操作
     * @param e
     */
    @Override
    public void enqueue(E e) {
        array.addLast(e);
    }

    /***
     * 获取队列的容量
     * @return
     */
    public int getCapcity() {
        return array.getCapacity();
    }

    /***
     * 判断队列是不是空的
     * @return
     */
    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    /***
     * 序列化输出的队列结果
     * @return
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Queue:");
        builder.append("front [");
        for (int i = 0; i < array.getSize(); i++) {
            builder.append(array.get(i));
            if (i != array.getSize() - 1) {
                builder.append(", ");
            }
        }
        builder.append("] tail");

        return builder.toString();
    }

    /***
     * 测试使用的主方法
     * @param args
     */
    public static void main(String[] args) {
        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>();
        for (int i = 0; i < 10; i++) {
            arrayQueue.enqueue(i);
            System.out.println(arrayQueue);
            if (i % 3 == 2) {
                arrayQueue.dequeue();
                System.out.println(arrayQueue);

            }
        }

    }
}
