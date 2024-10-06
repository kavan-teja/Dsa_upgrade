import java.util.ArrayList;
import java.util.Scanner;

public class maxheapdemo {
    private ArrayList<Integer> heap;

    public maxheapdemo() {
        heap = new ArrayList<>();
    }

    private void heapifyUp(int index) {
        int parent = (index - 1) / 2;
        if (index > 0 && heap.get(index) > heap.get(parent)) {
            swap(index, parent);
            heapifyUp(parent);
        }
    }

    private void heapifyDown(int index) {
        int largest = index;
        int left = 2 * index + 1;
        int right = 2 * index + 2;

        if (left < heap.size() && heap.get(left) > heap.get(largest)) {
            largest = left;
        }

        if (right < heap.size() && heap.get(right) > heap.get(largest)) {
            largest = right;
        }

        if (largest != index) {
            swap(index, largest);
            heapifyDown(largest);
        }
    }

    private void swap(int i, int j) {
        int temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    public void insert(int value) {
        heap.add(value);
        heapifyUp(heap.size() - 1);
    }

    public int deleteMax() {
        if (heap.isEmpty()) {
            throw new IllegalStateException("Heap is empty");
        }

        int max = heap.get(0);
        int lastElement = heap.remove(heap.size() - 1);

        if (!heap.isEmpty()) {
            heap.set(0, lastElement);
            heapifyDown(0);
        }

        return max;
    }

    public void printHeap() {
        System.out.println(heap);
    }

    public static void main(String[] args) {
        maxheapdemo maxHeap = new maxheapdemo();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMax Heap Operations:");
            System.out.println("1. Insert");
            System.out.println("2. Delete Max");
            System.out.println("3. Print Heap");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter value to insert: ");
                    int value = scanner.nextInt();
                    maxHeap.insert(value);
                    System.out.println("Inserted " + value);
                    break;
                case 2:
                    try {
                        int max = maxHeap.deleteMax();
                        System.out.println("Deleted max element: " + max);
                    } catch (IllegalStateException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    System.out.print("Current Heap: ");
                    maxHeap.printHeap();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}