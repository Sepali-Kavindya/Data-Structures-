import java.util.LinkedList;
import java.util.Queue;

public class DequeUsingTwoQueues {
    private Queue<Integer> queue1;
    private Queue<Integer> queue2;

    public DequeUsingTwoQueues() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    // Insert element at the front
    public void pushFront(int item) {
        // Move all elements from queue1 to queue2
        while (!queue1.isEmpty()) {
            queue2.add(queue1.remove());
        }
        // Add the new item to queue1
        queue1.add(item);
        // Move all elements back to queue1 from queue2
        while (!queue2.isEmpty()) {
            queue1.add(queue2.remove());
        }
    }

    // Insert element at the back
    public void pushBack(int item) {
        // Directly add the item to the back of queue1
        queue1.add(item);
    }

    // Remove element from the front
    public int popFront() {
        if (queue1.isEmpty()) {
            throw new RuntimeException("pop from an empty deque");
        }
        return queue1.remove();
    }

    // Remove element from the back
    public int popBack() {
        if (queue1.isEmpty()) {
            throw new RuntimeException("pop from an empty deque");
        }
        // Move all elements except the last one to queue2
        while (queue1.size() > 1) {
            queue2.add(queue1.remove());
        }
        // The last element is to be removed
        int item = queue1.remove();
        // Move all elements back to queue1 from queue2
        while (!queue2.isEmpty()) {
            queue1.add(queue2.remove());
        }
        return item;
    }

    public static void main(String[] args) {
        DequeUsingTwoQueues deque = new DequeUsingTwoQueues();
        deque.pushFront(10);
        deque.pushBack(20);
        System.out.println(deque.popFront());  // Output: 10
        deque.pushFront(30);
        System.out.println(deque.popBack());   // Output: 20
        System.out.println(deque.popFront());  // Output: 30
    }
}
