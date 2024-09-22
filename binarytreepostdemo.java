import java.util.*;

class Node {
    int data;
    Node left, right;

    public Node(int item) {
        data = item;
        left = right = null;
    }
}

public class binarytreepostdemo {
    private static int index;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter the number of nodes in the binary tree:");
        int n = scanner.nextInt();
        
        int[] postorder = new int[n];
        System.out.println("Enter the post-order traversal of the binary tree (space-separated):");
        for (int i = 0; i < n; i++) {
            postorder[i] = scanner.nextInt();
        }
        
        index = n - 1;
        Node root = constructTree(postorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
        
        System.out.println("Binary tree constructed successfully!");
        System.out.println("In-order traversal of the constructed tree:");
        inorderTraversal(root);
        
        scanner.close();
    }

    private static Node constructTree(int[] postorder, int min, int max) {
        if (index < 0) {
            return null;
        }

        int value = postorder[index];
        if (value < min || value > max) {
            return null;
        }

        Node root = new Node(value);
        index--;

        root.right = constructTree(postorder, value + 1, max);
        root.left = constructTree(postorder, min, value - 1);

        return root;
    }

    private static void inorderTraversal(Node node) {
        if (node != null) {
            inorderTraversal(node.left);
            System.out.print(node.data + " ");
            inorderTraversal(node.right);
        }
    }
}   