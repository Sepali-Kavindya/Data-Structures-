import java.util.ArrayList;

public class ArrayListQueue<E> {
    private ArrayList<E> list;

    public ArrayListQueue() {
        list = new ArrayList<>();
    }

    public void enqueue(E item) {
        list.add(item);
    }

    public E dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return list.remove(0);
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public int size() {
        return list.size();
    }

    public static void main(String[] args) {
        ArrayListQueue<Integer> queue = new ArrayListQueue<>();
        
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
