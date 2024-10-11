import java.util.LinkedList;
import java.util.Scanner;

class HashTable {
    private int size;
    private LinkedList<Integer>[] table;


    public HashTable(int size) {
        this.size = size;
        table = new LinkedList[size];
        for (int i = 0; i < size; i++) {
            table[i] = new LinkedList<>();
        }
    }

    private int hash(int key) {
        return key % size;
    }

    public void insert(int key) {
        int index = hash(key);
        table[index].add(key);
    }

    public boolean search(int key) {
        int index = hash(key);
        return table[index].contains(key);
    }

    public void display() {
        for (int i = 0; i < size; i++) {
            System.out.print("Bucket " + i + ": ");
            for (Integer key : table[i]) {
                System.out.print(key+" -> ");
            }
            System.out.println("Null");
        }
    }
}

public class openhashing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the size of the hash table: ");
        int size = scanner.nextInt();

        HashTable hashTable = new HashTable(size);

        while (true) {
            System.out.println("\n1. Insert");
            System.out.println("2. Search");
            System.out.println("3. Display");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter the key to insert: ");
                    int insertKey = scanner.nextInt();
                    hashTable.insert(insertKey);
                    System.out.println("Key inserted successfully.");
                    break;
                case 2:
                    System.out.print("Enter the key to search: ");
                    int searchKey = scanner.nextInt();
                    boolean found = hashTable.search(searchKey);
                    if (found) {
                        System.out.println("Key found in the hash table.");
                    } else {
                        System.out.println("Key not found in the hash table.");
                    }
                    break;
                case 3:
                    System.out.println("Hash Table Contents:");
                    hashTable.display();
                    break;
                case 4:
                    System.out.println("Exiting the program.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}