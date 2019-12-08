package DataStructures;

public class Queue {
    private int[] array;
    private int front;
    private int rear;
    private int size;

    public Queue(int length) {
        this.array = new int[length];
    }

    public int enQueue(int element) throws Exception {
        if ((rear + 1) % array.length == front) {
            throw new Exception("队列已满");
        }
        array[rear] = element;
        rear = (rear + 1) % array.length;
        size++;
        return element;
    }

    public int deQueue() throws Exception {
        if (rear == front) {
            throw new Exception("队列为空");
        }
        int element = array[front];
        front = (front + 1) % array.length;
        size--;
        return element;
    }

    public void printQueue() {
        for (int i = front; i != rear; i = (i + 1) % array.length) {
            System.out.println(array[i]);
        }
    }

    public int getSize() {
        return this.size;
    }

    public static void main(String[] args) throws Exception {
        Queue queue = new Queue(5);

        System.out.println(queue.enQueue(1) + "入队，当前队列长度为：" + queue.getSize());
        System.out.println(queue.enQueue(2) + "入队，当前队列长度为：" + queue.getSize());
        System.out.println(queue.enQueue(3) + "入队，当前队列长度为：" + queue.getSize());
        System.out.println(queue.enQueue(4) + "入队，当前队列长度为：" + queue.getSize());
        System.out.println(queue.deQueue() + "出队，当前队列长度为：" + queue.getSize());
        System.out.println(queue.deQueue() + "出队，当前队列长度为：" + queue.getSize());
        System.out.println(queue.deQueue() + "出队，当前队列长度为：" + queue.getSize());
        System.out.println(queue.deQueue() + "出队，当前队列长度为：" + queue.getSize());
    }

}
