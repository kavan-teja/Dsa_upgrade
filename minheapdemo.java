import java.util.Scanner;

public class minheapdemo {
    private int[] heap;
    private int size;
    private int capacity;

    public minheapdemo(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.heap = new int[capacity];
    }

    private int parent(int i) {
        return (i - 1) / 2;
    }

    private int leftChild(int i) {
        return 2 * i + 1;
    }

    private int rightChild(int i) {
        return 2 * i + 2;
    }

    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    public void insert(int key) {
        if (size == capacity) {
            System.out.println("Heap is full. Cannot insert.");
            return;
        }

        size++;
        int i = size - 1;
        heap[i] = key;

        while (i != 0 && heap[parent(i)] > heap[i]) {
            swap(i, parent(i));
            i = parent(i);
        }
    }

    private void minHeapify(int i) {
        int l = leftChild(i);
        int r = rightChild(i);
        int smallest = i;

        if (l < size && heap[l] < heap[smallest])
            smallest = l;
        if (r < size && heap[r] < heap[smallest])
            smallest = r;

        if (smallest != i) {
            swap(i, smallest);
            minHeapify(smallest);
        }
    }

    public int deleteMin() {
        if (size <= 0) {
            System.out.println("Heap is empty. Cannot delete.");
            return -1;
        }
        if (size == 1) {
            size--;
            return heap[0];
        }

        int root = heap[0];
        heap[0] = heap[size - 1];
        size--;
        minHeapify(0);

        return root;
    }

    

    public void printHeap() {
        for (int i = 0; i < size; i++) {
            System.out.print(heap[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the capacity of the heap: ");
        int capacity = scanner.nextInt();
        minheapdemo minHeap = new minheapdemo(capacity);

        while (true) {
            System.out.println("\n1. Insert\n2. Delete Min\n3. Print Heap\n4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter the element to insert: ");
                    int element = scanner.nextInt();
                    minHeap.insert(element);
                    break;
                case 2:
                    int min = minHeap.deleteMin();
                    if (min != -1) {
                        System.out.println("Deleted min element: " + min);
                    }
                    break;
                case 3:
                    System.out.print("Current heap: ");
                    minHeap.printHeap();
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