import java.lang.reflect.Array;

public class ArrayQueue<E> implements Queue<E> {
    private ArrayOne<E> array;

    public ArrayQueue(int capacity) {
        array = new ArrayOne<>(capacity);

    }

    public ArrayQueue() {
        array = new ArrayOne<>();
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public E getFront() {
        return array.getFrist();
    }

    @Override
    public E dequeue() {
        return array.removeFrist();
    }

    @Override
    public void enqueue(E e) {
        array.addLast(e);
    }

    public int getCapcity() {
        return array.getCapacity();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

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

    public static void main(String[] args) {
        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>();
        for (int i = 0; i < 10; i++) {
            arrayQueue.enqueue(i);
            System.out.println(arrayQueue);
            if(i%3==2){
                arrayQueue.dequeue();
                System.out.println(arrayQueue);

            }
        }

    }
}
