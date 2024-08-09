class Node {
    int key;
    Node left, right;

    public Node(int item) {
        key = item;
        left = right = null;
    }
}

public class BinaryTree {
    Node root;

    public BinaryTree() {
        root = null;
    }

    // Insertion method
    public void insert(int key) {
        root = insertRec(root, key);
    }

    // A recursive function to insert a new key in BST
    private Node insertRec(Node root, int key) {
        if (root == null) {
            root = new Node(key);
            return root;
        }

        if (key < root.key)
            root.left = insertRec(root.left, key);
        else if (key > root.key)
            root.right = insertRec(root.right, key);

        return root;
    }

    // Deletion method
    public void delete(int key) {
        root = deleteRec(root, key);
    }

    // A recursive function to delete a key in BST
    private Node deleteRec(Node root, int key) {
        if (root == null) return root;

        if (key < root.key)
            root.left = deleteRec(root.left, key);
        else if (key > root.key)
            root.right = deleteRec(root.right, key);
        else {
            // Node with only one child or no child
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;

            // Node with two children: Get the inorder successor (smallest in the right subtree)
            root.key = minValue(root.right);

            // Delete the inorder successor
            root.right = deleteRec(root.right, root.key);
        }

        return root;
    }

    // Find the node with the minimum value (used in deletion)
    private int minValue(Node root) {
        int minv = root.key;
        while (root.left != null) {
            minv = root.left.key;
            root = root.left;
        }
        return minv;
    }

    // Pre-order traversal: Root -> Left -> Right
    public void preOrder() {
        preOrderRec(root);
        System.out.println(); // Print a newline after traversal
    }

    private void preOrderRec(Node root) {
        if (root != null) {
            System.out.print(root.key + " ");
            preOrderRec(root.left);
            preOrderRec(root.right);
        }
    }

    // In-order traversal: Left -> Root -> Right
    public void inOrder() {
        inOrderRec(root);
        System.out.println(); // Print a newline after traversal
    }

    private void inOrderRec(Node root) {
        if (root != null) {
            inOrderRec(root.left);
            System.out.print(root.key + " ");
            inOrderRec(root.right);
        }
    }

    // Post-order traversal: Left -> Right -> Root
    public void postOrder() {
        postOrderRec(root);
        System.out.println(); // Print a newline after traversal
    }

    private void postOrderRec(Node root) {
        if (root != null) {
            postOrderRec(root.left);
            postOrderRec(root.right);
            System.out.print(root.key + " ");
        }
    }

    // Main method for testing the BinaryTree class
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        // Insert nodes into the tree
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);

        // Perform traversals
        System.out.println("In-order traversal:");
        tree.inOrder();  // Expected Output: 20 30 40 50 60 70 80

        System.out.println("Pre-order traversal:");
        tree.preOrder(); // Expected Output: 50 30 20 40 70 60 80

        System.out.println("Post-order traversal:");
        tree.postOrder(); // Expected Output: 20 40 30 60 80 70 50

        // Delete a node and perform in-order traversal again
        System.out.println("\nDeleting node 20");
        tree.delete(20);
        System.out.println("In-order traversal after deletion:");
        tree.inOrder();  // Expected Output: 30 40 50 60 70 80
    }
}