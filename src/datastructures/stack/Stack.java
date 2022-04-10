/**
 * A stack is a linear data structure that follows the principle of Last In First Out (LIFO).
 * This means the last element inserted inside the stack is removed first.
 * <p>
 * Stack can be represented similar to a pile of plates
 * You can perform below operations on it:
 * - Put a new plate on top
 * - Remove the top plate
 * <p>
 * There are 5 operations that you can perform on a Stack
 * - Push : Putting an item on top of the stack
 * - Pop  : Removing an item from top of the stack.
 * - Is Empty : Check if the stack is empty
 * - Is Full : Check if the stack is full
 * - Peek : Get the top element without removing it from the Stack.
 */
package datastructures.stack;
public class Stack {
    private int stack[];
    private int top;
    private int size;

    /**
     * Create stack with the given size
     */
    public Stack(int size) {
        stack = new int[size];
        this.size = size;
        top = -1;
    }

    /**
     * This method is to push a given value into the stack.
     * Before it, it checks whether is stack is full, if full it exits the program,
     * Otherwise, it inserts the given value into stack
     *
     * @param value
     */
    public void push(int value) {
        if (isStackFull()) {
            System.out.println("Stack is Full...!!!\n");
        }
        else {
            stack[++top] = value;
            System.out.println("Inserted " + value);
            //printStackElements();
        }
    }

    /**
     * This method removes the top value from the stack.
     * Before it, it checks whether is stack empty, if empty it exits the program,
     * Otherwise, it removes the top value from stack
     */
    public void pop() {
        if (isStackEmpty()) {
            System.out.println("Stack is Empty...!!!, Cant push anymore");
        }
        else
        {
            top --;
        }
    }

    /**
     * This method returns the latest value from the stack.
     * Before it, it checks whether is stack empty, if empty it exits the program,
     * Otherwise, it returns the top value from stack
     */
    public int peek() {
        if (isStackEmpty()) {
            System.out.println("Stack is Empty...!!!, Cant push anymore");
        }
        else {
            return stack[top];
        }
        return -1;
    }

    /**
     * This method returns true if the stack is empty(means top is -1, means no values in stack)
     *
     * @return
     */
    public boolean isStackEmpty() {
        return top == -1;
    }

    /**
     * This method returns true if the stack is full(means top is pointing to the max position of the stack)
     *
     * @return
     */
    public boolean isStackFull() {
        return top == size - 1;
    }

    /**
     * This is just a utility method that is used to print the elements of the stack.
     */
    public void printStackElements() {
        for (int i = 0; i <= top; i++) {
            System.out.print(stack[i] + " ");
        }
        for (int i = top + 1; i < size; i++) {
            System.out.print("<empty> ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Stack stack = new Stack(5);

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        stack.pop();
        System.out.println("\nAfter popping out");

        stack.printStackElements();

        System.out.println(stack.peek());

        stack.push(4);
        stack.push(5);
        stack.printStackElements();
        stack.push(6);
    }
}