import java.util.Deque;
import java.util.LinkedList;

public class DequeStack {
    private Deque<Integer> deque;

    public DequeStack() {
        deque = new LinkedList<>();
    }

    public void push(int element) {
        deque.push(element);
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty, cannot pop element.");
            return -1; // or throw an exception
        }
        return deque.pop();
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
            return -1; // or throw an exception
        }
        return deque.peek();
    }

    public boolean isEmpty() {
        return deque.isEmpty();
    }

    public static void main(String[] args) {
        DequeStack stack = new DequeStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println("Top element: " + stack.peek());

        System.out.println("Popped element: " + stack.pop());
        System.out.println("Popped element: " + stack.pop());
        System.out.println("Popped element: " + stack.pop());
    }
}
