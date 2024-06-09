public class Stack {

    private int maxSize; // Maximum size of the stack
    private Object[] stackArray; // Array to hold the stack elements
    private int top; // Index of the top element in the stack

    // Constructor to initialize the stack with a given size
    public Stack(int size) {
        maxSize = size;
        stackArray = new Object[maxSize];
        top = -1; // Initialize top as -1 to indicate an empty stack
    }

    // Method to push an element onto the stack
    public void push(Object value) {
        if (isFull()) {
            System.out.println("Stack is full. Cannot push element.");
            return;
        }
        top++; // Increment top to move to the next empty position
        stackArray[top] = value; // Place the new element at the top
    }

    // Method to pop an element from the stack
    public Object pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty. Cannot pop element.");
            return -1; // Return -1 indicating an error or underflow
        }
        Object poppedElement = stackArray[top]; // Get the top element
        stackArray[top] = null; // Remove the top element
        top--; // Decrement top to move to the previous element
        return poppedElement; // Return the popped element
    }

    // Method to peek at the top element of the stack
    public Object peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty. Cannot peek element.");
            return -1; // Return -1 indicating an error or underflow
        }
        return stackArray[top]; // Return the top element without removing it
    }

    // Method to check if the stack is empty
    public boolean isEmpty() {
        return (top == -1);
    }

    // Method to check if the stack is full
    public boolean isFull() {
        return (top == maxSize - 1);
    }

    // Method to display the elements of the stack
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i <= top; i++) {
            sb.append(stackArray[i]);
            if (i < top) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    // Main method for testing the stack
    public static void main(String[] args) {
        Stack stack = new Stack(5); // Create a stack with size 5
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println("Stack after pushing elements: " + stack);

        System.out.println("Popped element: " + stack.pop());
        System.out.println("Stack after popping element: " + stack);

        System.out.println("Peeked element: " + stack.peek());
    }
}
