/**
 * A queue is a data structure that follows the principle of Fast In First Out (LIFO).
 * This means the first element inserted inside the queue is removed first.
 * <p>
 * Queue can be represented similar to a pile of plates
 * You can perform below operations on it:
 * - Put a new plate on top
 * - Remove the top plate
 * <p>
 * There are 5 operations that you can perform on a Queue
 * - Enqueue: Add an element to the end of the queue
 * - Dequeue: Remove an element from the front of the queue
 * - Is Empty: Check if the queue is empty
 * - Is Full: Check if the queue is full
 * - Peek: Get the value of the front of the queue without removing it
 */
package src.queue;
public class Queue {
    int size = 5;
    int[] items;
    int front, rear;

    Queue(int size) {
        this.size = size;
        items = new int[size];
        front = -1;
        rear = -1;
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is Empty...!!!, Cant push anymore");
            System.exit(1);
        }
        return items[front];
    }

    public boolean isEmpty() {
        if (front == -1)
            return true;
        else
            return false;
    }

    public boolean isFull() {
        if (front == 0 && rear == size - 1) {
            return true;
        }
        return false;
    }

    void enQueue(int element) {
        if (isFull()) {
            System.out.println("Queue is full");
        } else {
            if (front == -1)
                front = 0;
            rear++;
            items[rear] = element;
            System.out.println("Enqueued " + element);
        }
    }

    int deQueue() {
        int element;
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return (-1);
        } else {
            element = items[front];
            if (front >= rear) {
                front = -1;
                rear = -1;
            } else {
                front++;
            }
            System.out.println("Dequeued -> " + element);
            return (element);
        }
    }

    void printQueue() {
        if (isEmpty()) {
            System.out.println("Queue is Empty");
        } else {
            System.out.print("Front " + front + " ;; ");
            System.out.print("Rear " + rear + " ;; ");
            System.out.print("Queue -> ");
            for (int i = front; i <= rear; i++) {
                System.out.print(items[i] + "  ");
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Queue queue = new Queue(5);

        queue.deQueue();

        queue.enQueue(1);
        queue.enQueue(2);
        queue.enQueue(3);
        queue.enQueue(4);
        queue.enQueue(5);

        queue.enQueue(6);

        System.out.println("Peek : " + queue.peek());

        queue.printQueue();

        queue.deQueue();

        queue.printQueue();
    }
}