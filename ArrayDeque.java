import java.util.ArrayDeque;

public class ArrayDequeQueue<E> {
    private ArrayDeque<E> deque;

    public ArrayDequeQueue() {
        deque = new ArrayDeque<>();
    }

    public void enqueue(E item) {
        deque.add(item);
    }

    public E dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return deque.remove();
    }

    public boolean isEmpty() {
        return deque.isEmpty();
    }

    public int size() {
        return deque.size();
    }

    public static void main(String[] args) {
        ArrayDequeQueue<Integer> queue = new ArrayDequeQueue<>();
        
        // Enqueue elements
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        
        // Dequeue elements
        System.out.println(queue.dequeue()); // Output: 1
        System.out.println(queue.dequeue()); // Output: 2
        System.out.println(queue.dequeue()); // Output: 3
        
        // Check if queue is empty
        System.out.println(queue.isEmpty()); // Output: true
    }
}
