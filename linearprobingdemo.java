import java.util.Scanner;

class HashTable {
    private int size;
    private Integer[] table;
    private boolean[] isDeleted;

    public HashTable(int size) {
        this.size = size;
        table = new Integer[size];
        isDeleted = new boolean[size];
    }

    private int hash(int key) {
        return key % size;
    }

    public void insert(int key) {
        int index = hash(key);
        int i = 0;
        while (i < size) {
            int probeIndex = (index + i) % size;
            if (table[probeIndex] == null || isDeleted[probeIndex]) {
                table[probeIndex] = key;
                isDeleted[probeIndex] = false;
                System.out.println("Key inserted successfully at index " + probeIndex);
                return;
            }
            i++;
        }
        System.out.println("Hash table is full. Cannot insert key.");
    }

    public boolean search(int key) {
        int index = hash(key);
        int i = 0;
        while (i < size) {
            int probeIndex = (index + i) % size;
            if (table[probeIndex] == null && !isDeleted[probeIndex]) {
                return false;
            }
            if (table[probeIndex] != null && table[probeIndex] == key && !isDeleted[probeIndex]) {
                return true;
            }
            i++;
        }
        return false;
    }

    public void delete(int key) {
        int index = hash(key);
        int i = 0;
        while (i < size) {
            int probeIndex = (index + i) % size;
            if (table[probeIndex] == null && !isDeleted[probeIndex]) {
                System.out.println("Key not found in the hash table.");
                return;
            }
            if (table[probeIndex] != null && table[probeIndex] == key && !isDeleted[probeIndex]) {
                isDeleted[probeIndex] = true;
                System.out.println("Key deleted successfully from index " + probeIndex);
                return;
            }
            i++;
        }
        System.out.println("Key not found in the hash table.");
    }

    public void display() {
        for (int i = 0; i < size; i++) {
            if (table[i] != null && !isDeleted[i]) {
                System.out.println("Index " + i + ": " + table[i]);
            } else {
                System.out.println("Index " + i + ": Empty");
            }
        }
    }
}

public class linearprobingdemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the size of the hash table: ");
        int size = scanner.nextInt();

        HashTable hashTable = new HashTable(size);

        while (true) {
            System.out.println("\n1. Insert");
            System.out.println("2. Search");
            System.out.println("3. Delete");
            System.out.println("4. Display");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter the key to insert: ");
                    int insertKey = scanner.nextInt();
                    hashTable.insert(insertKey);
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
                    System.out.print("Enter the key to delete: ");
                    int deleteKey = scanner.nextInt();
                    hashTable.delete(deleteKey);
                    break;
                case 4:
                    System.out.println("Hash Table Contents:");
                    hashTable.display();
                    break;
                case 5:
                    System.out.println("Exiting the program.");
                    scanner.close();
                    System.out.println("Successfully exited from the program....");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}