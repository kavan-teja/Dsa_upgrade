import java.util.Scanner;

class Node {
    int data;
    Node left, right;

    public Node(int item) {
        data = item;
        left = right = null;
    }
}

public class binarytreepredemo {
    static int index = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of nodes: ");
        int n = scanner.nextInt();

        int[] preorder = new int[n];
        
        System.out.println("Enter the preorder traversal of the binary tree:");
        for (int i = 0; i < n; i++) {
            preorder[i] = scanner.nextInt();
        }

        Node root = constructTree(preorder);

        System.out.println("Inorder traversal of the constructed tree:");
        inorderTraversal(root);

        scanner.close();
    }

    static Node constructTree(int[] preorder) {
        return constructTreeUtil(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    static Node constructTreeUtil(int[] preorder, int min, int max) {
        if (index >= preorder.length) {
            return null;
        }

        int key = preorder[index];
        if (key < min || key > max) {
            return null;
        }

        Node root = new Node(key);
        index++;

        root.left = constructTreeUtil(preorder, min, key - 1);
        root.right = constructTreeUtil(preorder, key + 1, max);

        return root;
    }

    static void inorderTraversal(Node root) {
        if (root != null) {
            inorderTraversal(root.left);
            System.out.print(root.data + " ");
            inorderTraversal(root.right);
        }
    }
}