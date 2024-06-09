public class Steque<T> {
    private Node<T> front;
    private Node<T> rear;
    private int size;

    private static class Node<T> {
        private T item;
        private Node<T> next;

        public Node(T item) {
            this.item = item;
        }
    }

    public Steque() {
        front = null;
        rear = null;
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void push(T item) {
        Node<T> newNode = new Node<>(item);
        if (isEmpty()) {
            front = newNode;
            rear = newNode;
        } else {
            newNode.next = front;
            front = newNode;
        }
        size++;
    }

    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Steque is empty, cannot pop.");
        }
        T item = front.item;
        front = front.next;
        if (front == null) {
            rear = null;
        }
        size--;
        return item;
    }

    public void enqueue(T item) {
        Node<T> newNode = new Node<>(item);
        if (isEmpty()) {
            front = newNode;
            rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        size++;
    }

    public static void main(String[] args) {
        Steque<Integer> steque = new Steque<>();

        steque.push(10);
        steque.push(20);
        steque.enqueue(30);
        steque.enqueue(40);

        System.out.println("Popped item: " + steque.pop()); // Should print 20
        System.out.println("Popped item: " + steque.pop()); // Should print 10

        steque.push(50);
        steque.enqueue(60);

        while (!steque.isEmpty()) {
            System.out.println("Popped item: " + steque.pop());
        }
    }
}
