import java.util.Scanner;

public class quadraticprobing {
    private static final int TABLE_SIZE = 13;
    private Integer[] table;

    public quadraticprobing() {
        table = new Integer[TABLE_SIZE];
    }

    private int hash(int key) {
        return key % TABLE_SIZE;
    }

    public void insert(int key) {
        int index = hash(key);
        int i = 0;

        while (table[index] != null) {
            index = (index + i * i) % TABLE_SIZE;
            i++;
            if (i == TABLE_SIZE) {
                System.out.println("Table is full. Cannot insert " + key);
                return;
            }
        }

        table[index] = key;
        System.out.println(key + " inserted at index " + index);
    }

    public boolean search(int key) {
        int index = hash(key);
        int i = 0;

        while (table[index] != null) {
            if (table[index] == key) {
                System.out.println(key + " found at index " + index);
                return true;
            }
            index = (index + i * i) % TABLE_SIZE;
            i++;
            if (i == TABLE_SIZE) {
                break;
            }
        }

        System.out.println(key + " not found in the table");
        return false;
    }

    public void delete(int key) {
        int index = hash(key);
        int i = 0;

        while (table[index] != null) {
            if (table[index] == key) {
                table[index] = null;
                System.out.println(key + " deleted from index " + index);
                return;
            }
            index = (index + i * i) % TABLE_SIZE;
            i++;
            if (i == TABLE_SIZE) {
                break;
            }
        }

        System.out.println(key + " not found in the table. Cannot delete.");
    }

    public void display() {
        System.out.println("Hash Table:");
        for (int i = 0; i < TABLE_SIZE; i++) {
            if (table[i] != null) {
                System.out.println("Index " + i + ": " + table[i]);
            } else {
                System.out.println("Index " + i + ": Empty");
            }
        }
    }

    public static void main(String[] args) {
        quadraticprobing hashTable = new quadraticprobing();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Insert\n2. Search\n3. Delete\n4. Display\n5. Exit");
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
                    hashTable.search(searchKey);
                    break;
                case 3:
                    System.out.print("Enter the key to delete: ");
                    int deleteKey = scanner.nextInt();
                    hashTable.delete(deleteKey);
                    break;
                case 4:
                    hashTable.display();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}