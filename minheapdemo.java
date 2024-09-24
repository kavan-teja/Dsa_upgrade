import java.util.ArrayList;
import java.util.Scanner;

class MinHeap {
    private ArrayList<Integer> heap;

    public MinHeap() {
        heap = new ArrayList<>();
    }

    private void swap(int i, int j) {
        int temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    private void heapifyUp(int index) {
        int parent = (index - 1) / 2;
        if (index > 0 && heap.get(index) < heap.get(parent)) {
            swap(index, parent);
            heapifyUp(parent);
        }
    }

    private void heapifyDown(int index) {
        int minIndex = index;
        int left = 2 * index + 1;
        int right = 2 * index + 2;

        if (left < heap.size() && heap.get(left) < heap.get(minIndex)) {
            minIndex = left;
        }

        if (right < heap.size() && heap.get(right) < heap.get(minIndex)) {
            minIndex = right;
        }

        if (minIndex != index) {
            swap(index, minIndex);
            heapifyDown(minIndex);
        }
    }

    public void insert(int value) {
        heap.add(value);
        heapifyUp(heap.size() - 1);
    }

    public int deleteMin() {
        if (heap.isEmpty()) {
            throw new IllegalStateException("Heap is empty");
        }

        int min = heap.get(0);
        int lastElement = heap.remove(heap.size() - 1);

        if (!heap.isEmpty()) {
            heap.set(0, lastElement);
            heapifyDown(0);
        }

        return min;
    }

    public void printHeap() {
        System.out.println(heap);
    }

    public boolean isEmpty() {
        return heap.isEmpty();
    }
}

public class minheapdemo {
    public static void main(String[] args) {
        MinHeap minHeap = new MinHeap();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Insert");
            System.out.println("2. Delete minimum");
            System.out.println("3. Print heap");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter value to insert: ");
                    int value = scanner.nextInt();
                    minHeap.insert(value);
                    System.out.println("Inserted " + value);
                    break;
                case 2:
                    if (!minHeap.isEmpty()) {
                        int min = minHeap.deleteMin();
                        System.out.println("Deleted minimum: " + min);
                    } else {
                        System.out.println("Heap is empty");
                    }
                    break;
                case 3:
                    System.out.print("Current heap: ");
                    minHeap.printHeap();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
} {
    
}
