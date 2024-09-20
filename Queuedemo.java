import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Queuedemo {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.println("\nQueue Operations:");
            System.out.println("1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Peek");
            System.out.println("4. Display");
            System.out.println("5. Exit");
            System.out.print("Enter your choice (1-5): ");
            
            int choice = scanner.nextInt();
            
            switch (choice) {
                case 1:
                    System.out.print("Enter the element to enqueue: ");
                    int element = scanner.nextInt();
                    queue.offer(element);
                    System.out.println(element + " enqueued to the queue");
                    break;
                case 2:
                    if (!queue.isEmpty()) {
                        System.out.println(queue.poll() + " dequeued from the queue");
                    } else {
                        System.out.println("Queue is empty");
                    }
                    break;
                case 3:
                    if (!queue.isEmpty()) {
                        System.out.println("Front element: " + queue.peek());
                    } else {
                        System.out.println("Queue is empty");
                    }
                    break;
                case 4:
                    if (!queue.isEmpty()) {
                        System.out.println("Queue elements: " + queue);
                    } else {
                        System.out.println("Queue is empty");
                    }
                    break;
                case 5:
                    System.out.println("Exiting the program");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}