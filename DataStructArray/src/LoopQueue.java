/***
 * 利用循环队列的原理实现
 * @param <E>  队列中的数据类型
 */
public class LoopQueue<E> implements Queue<E> {
    // 声明一个存放数据的数组
    private E[] data;
    // 两个记录头尾的位置的整形变量
    private int front, tail;
    // 记录元素个数的变量
    private int size;

    /***
     * 一个可以初始化一定容量的队列
     * @param capacity
     */
    public LoopQueue(int capacity) {
        data = (E[]) new Object[capacity + 1];
        front = 0;
        tail = 0;
        size = 0;
    }

    /***
     * 创建包含10元素的队列
     */
    public LoopQueue() {
        this(10);
    }

    /***
     * 获取队列的容量
     * @return
     */
    public int getCapacity() {
        return data.length - 1;
    }

    /***
     * 判断队列是不是空的
     * @return
     */
    @Override
    public boolean isEmpty() {
        return front == tail;
    }

    @Override
    public int getSize() {
        return size;
    }

       @Override
    public void enqueue(E e) {
        if ((tail + 1) % data.length == front)
            // 数组扩容的过程
            resize(getCapacity() * 2);


        data[tail] = e;
        tail = (tail + 1) % data.length ;
        size++;


    }

    @Override
    public E dequeue(){

        if(isEmpty())
            throw new IllegalArgumentException("Cannot dequeue from an empty queue.");

        E ret = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size --;
        if(size == getCapacity() / 4 && getCapacity() / 2 != 0)
            resize(getCapacity() / 2);
        return ret;
    }
    @Override
    public E getFront() {
        if (isEmpty())
            throw new IllegalArgumentException("Queue is empty");
        return data[front];
    }

    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity + 1];
        for (int i = 0; i < size; i++)
            newData[i] = data[(i + front) % data.length];
            data = newData;
            front = 0;
            tail = size;


    }


    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Queue:size =  %d,capacity = %d\n", size
                , getCapacity()));
        res.append("front [");
        for (int i = front; i != tail; i = (i + 1) % data.length) {
            res.append(data[i]);
            if ((i+1)%data.length!=tail)
                res.append(", ");

        }
        res.append("] tail ");
        return res.toString();
    }
    public static void main(String[] args) {
        LoopQueue<Integer> arrayQueue = new LoopQueue<>();
        for(int i = 0 ; i < 10 ; i ++){
            arrayQueue.enqueue(i);
            System.out.println(arrayQueue);

            if(i % 3 == 2){
                arrayQueue.dequeue();
                System.out.println(arrayQueue);
            }
        }
    }
}
