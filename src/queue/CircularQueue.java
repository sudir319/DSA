package src.queue;

/**
 * This is same as Queue except the whenever deque happened, that space is not usable in normal
 * Circular Queue solves this problem by utilizing the space efficiently.
 */
public class CircularQueue {

    int size;
    int[] queue;
    int front = -1;
    int rear = -1;

    public CircularQueue(int size) {
        this.size = size;
        queue = new int[size];
    }

    public void enQueue(int value) {
        if(isQueueFull()) {
            System.out.println("Queue is full, cant insert " + value);
        }
        else
        {
            if(front == -1) {
                front ++;
            }
            rear = (++rear) % size;
            queue[rear] = value;

            System.out.println("Enqueued " + value);
        }
    }

    public void deQueue() {
        if(isQueueEmpty()) {
            System.out.println("Queue is Empty");
        }
        else
        {
            int value = queue[front];
            if (front == rear) {
                front = -1;
                rear = -1;
            }
            else {
                front = (++front) % size;
            }
            System.out.println("Dequeued " + value);
        }
    }

    private boolean isQueueFull() {
        if (front == 0 && rear == size - 1) {
            return true;
        }
        if (front == rear + 1) {
            return true;
        }
        return false;
    }

    private boolean isQueueEmpty() {
        //return front == rear && rear == -1;
        return front == -1;
    }

    private void printQueue() {
        //System.out.println(front + " : " + rear + " : " + size);
        if(isQueueEmpty()) {
            System.out.println("Queue is Empty");
        }
        else
        {
            System.out.print("Front : " + front + " ;; " );
            System.out.print("Rear : " + rear + " ;; " );
            System.out.print("Queue elements are : ");
            for (int i = front; i <= rear; i ++)
                System.out.print(queue[i % size] + " ");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        CircularQueue cq = new CircularQueue(5);
        cq.enQueue(1);
        cq.enQueue(2);
        cq.enQueue(3);
        cq.enQueue(4);
        cq.enQueue(5);
        cq.printQueue();
        cq.deQueue();
        cq.deQueue();
        cq.deQueue();
        cq.deQueue();
        cq.printQueue();
        cq.enQueue(6);
        cq.deQueue();
        cq.printQueue();
        cq.deQueue();
        cq.printQueue();
    }
}