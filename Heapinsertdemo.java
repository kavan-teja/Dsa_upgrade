import java.util.Scanner;

class Node {
    int data;
    Node next;
    
    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList {
    Node head;
    
    void insertAtHead(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }
    
    void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}

public class Heapinsertdemo {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.print("Enter a number to insert at the head (or -1 to quit): ");
            int number = scanner.nextInt();
            
            if (number == -1) {
                break;
            }
            
            list.insertAtHead(number);
            System.out.print("Current list: ");
            list.printList();
        }
        
        scanner.close();
        System.out.println("Final list:");
        list.printList();
    }
}