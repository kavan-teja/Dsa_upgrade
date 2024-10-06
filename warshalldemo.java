import java.util.Scanner;

public class warshalldemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of vertices in the graph: ");
        int n = scanner.nextInt();

        boolean[][] graph = new boolean[n][n];

        System.out.println("Enter the adjacency matrix (1 for edge, 0 for no edge):");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                graph[i][j] = scanner.nextInt() == 1;
            }
        }

        System.out.println("\nOriginal adjacency matrix:");
        printMatrix(graph);

        warshall(graph);

        System.out.println("\nTransitive closure matrix:");
        printMatrix(graph);

        scanner.close();
    }

    public static void warshall(boolean[][] graph) {
        int n = graph.length;

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    graph[i][j] = graph[i][j] || (graph[i][k] && graph[k][j]);
                }
            }
        }
    }

    public static void printMatrix(boolean[][] matrix) {
        for (boolean[] row : matrix) {
            for (boolean cell : row) {
                System.out.print((cell ? 1 : 0) + " ");
            }
            System.out.println();
        }
    }
}