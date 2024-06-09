import java.util.ArrayList;

public class StackUsingPush {
    private ArrayList<Integer> stack;

    public StackUsingPush() {
        stack = new ArrayList<>();
    }

    public void push(int element) {
        stack.add(element);
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty, cannot pop element.");
            return -1; // or throw an exception
        }
        int lastIndex = stack.size() - 1;
        int popped = stack.get(lastIndex);
        stack.remove(lastIndex);
        return popped;
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
            return -1; // or throw an exception
        }
        return stack.get(stack.size() - 1);
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        StackUsingPush stack = new StackUsingPush();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println("Top element: " + stack.peek());

        System.out.println("Popped element: " + stack.pop());
        System.out.println("Popped element: " + stack.pop());
        System.out.println("Popped element: " + stack.pop());
    }
}
