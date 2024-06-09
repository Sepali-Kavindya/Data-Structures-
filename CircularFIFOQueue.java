public class CircularFIFOQueue {
    private int[] queue;
    private int front;
    private int rear;
    private int size;
    private int capacity;

    // Constructor to initialize the queue with a specific capacity
    public CircularFIFOQueue(int capacity) {
        this.capacity = capacity;
        this.queue = new int[capacity];
        this.front = 0;
        this.rear = -1;
        this.size = 0;
    }

    // Method to add an element to the queue
    public void enqueue(int value) {
        if (isFull()) {
            throw new RuntimeException("Queue is full");
        }
        rear = (rear + 1) % capacity;
        queue[rear] = value;
        size++;
    }

    // Method to remove and return the front element from the queue
    public int dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        int value = queue[front];
        front = (front + 1) % capacity;
        size--;
        return value;
    }

    // Method to check if the queue is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Method to check if the queue is full
    public boolean isFull() {
        return size == capacity;
    }

    // Method to return the size of the queue
    public int getSize() {
        return size;
    }

    // Method to print the queue
    public void printQueue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }
        System.out.print("Queue: ");
        for (int i = 0; i < size; i++) {
            System.out.print(queue[(front + i) % capacity] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        CircularFIFOQueue queue = new CircularFIFOQueue(5);

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);

        queue.printQueue(); // Output: Queue: 1 2 3 4 5

        System.out.println("Dequeued: " + queue.dequeue()); // Output: Dequeued: 1
        queue.printQueue(); // Output: Queue: 2 3 4 5

        queue.enqueue(6);
        queue.printQueue(); // Output: Queue: 2 3 4 5 6

        System.out.println("Dequeued: " + queue.dequeue()); // Output: Dequeued: 2
        queue.printQueue(); // Output: Queue: 3 4 5 6

        System.out.println("Queue Size: " + queue.getSize()); // Output: Queue Size: 4
    }
}
