// Node class to represent each element in the linked list
class Node {
    int data;
    Node next;

    // Constructor to initialize the node with given data
    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

// Queue class implementing FIFO using linked list
class Queue {
    private Node front; // Front of the queue
    private Node rear;  // Rear of the queue

    // Constructor to initialize an empty queue
    public Queue() {
        this.front = null;
        this.rear = null;
    }

    // Method to add an element to the queue (enqueue operation)
    public void enqueue(int data) {
        Node newNode = new Node(data);

        // If the queue is empty, set front and rear to the new node
        if (isEmpty()) {
            front = newNode;
            rear = newNode;
        } else {
            // Otherwise, add the new node at the end and update rear
            rear.next = newNode;
            rear = newNode;
        }
    }

    // Method to remove an element from the queue (dequeue operation)
    public int dequeue() {
        // If queue is empty, throw an exception (in a real implementation)
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty, cannot dequeue");
        }

        // Get the data at the front of the queue
        int data = front.data;

        // Move front to the next node
        front = front.next;

        // If front becomes null, set rear to null as well
        if (front == null) {
            rear = null;
        }

        return data;
    }

    // Method to check if the queue is empty
    public boolean isEmpty() {
        return front == null;
    }

    // Method to peek at the front element of the queue without removing it
    public int peek() {
        // If queue is empty, throw an exception (in a real implementation)
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty, cannot peek");
        }
        return front.data;
    }
}

// Example usage of the Queue class
public class Main {
    public static void main(String[] args) {
        Queue queue = new Queue();

        // Enqueue elements
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        // Peek at the front element
        System.out.println("Front element: " + queue.peek());

        // Dequeue elements
        System.out.println(queue.dequeue() + " dequeued from the queue");
        System.out.println(queue.dequeue() + " dequeued from the queue");

        // Peek at the front element after dequeuing
        System.out.println("Front element after dequeuing: " + queue.peek());

        // Dequeue remaining elements
        System.out.println(queue.dequeue() + " dequeued from the queue");

        // Try to dequeue from an empty queue (this will throw an exception)
        // System.out.println(queue.dequeue());
    }
}
