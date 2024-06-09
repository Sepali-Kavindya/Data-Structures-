import java.util.Stack;

public class DequeueFriendlyQueue {
    private Stack<Integer> enqueueStack;
    private Stack<Integer> dequeueStack;

    public DequeueFriendlyQueue() {
        enqueueStack = new Stack<>();
        dequeueStack = new Stack<>();
    }

    // Enqueue operation (costly)
    public void enqueue(int x) {
        // Move all elements from enqueueStack to dequeueStack
        while (!enqueueStack.isEmpty()) {
            dequeueStack.push(enqueueStack.pop());
        }

        // Push the new element onto enqueueStack
        enqueueStack.push(x);

        // Move all elements back to enqueueStack from dequeueStack
        while (!dequeueStack.isEmpty()) {
            enqueueStack.push(dequeueStack.pop());
        }
    }

    // Dequeue operation (efficient)
    public int dequeue() {
        // If enqueueStack is empty, return -1 (or throw an exception based on your preference)
        if (enqueueStack.isEmpty()) {
            return -1;
        }
        // Pop the top element from enqueueStack which is the front of the queue
        return enqueueStack.pop();
    }

    public static void main(String[] args) {
        DequeueFriendlyQueue queue = new DequeueFriendlyQueue();
        
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        
        System.out.println(queue.dequeue()); // Output: 1
        System.out.println(queue.dequeue()); // Output: 2
        
        queue.enqueue(4);
        
        System.out.println(queue.dequeue()); // Output: 3
        System.out.println(queue.dequeue()); // Output: 4
        System.out.println(queue.dequeue()); // Output: -1 (or you can throw an exception)
    }
}
