import java.util.LinkedList;
import java.util.*;

public class bfsdemo {
    private int V; // Number of vertices
    private List<List<Integer>> adj; // Adjacency list

    public bfsdemo(int v) {
        V = v;
        adj = new ArrayList<>(v);
        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }
    }

    // Add an edge to the graph
    public void addEdge(int v, int w) {
        adj.get(v).add(w);
    }

    // BFS traversal from a given source vertex
    public void BFS(int s) {
        // Mark all vertices as not visited
        boolean[] visited = new boolean[V];

        // Create a queue for BFS
        LinkedList<Integer> queue = new LinkedList<>();

        // Mark the current node as visited and enqueue it
        visited[s] = true;
        queue.add(s);

        while (queue.size() != 0) {
            // Dequeue a vertex from queue and print it
            s = queue.poll();
            System.out.print(s + " ");

            // Get all adjacent vertices of the dequeued vertex s
            // If an adjacent has not been visited, then mark it visited
            // and enqueue it
            for (int n : adj.get(s)) {
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of vertices: ");
        int V = scanner.nextInt();
        bfsdemo g = new bfsdemo(V);

        System.out.print("Enter the number of edges: ");
        int E = scanner.nextInt();

        System.out.println("Enter the edges (format: source destination):");
        for (int i = 0; i < E; i++) {
            int src = scanner.nextInt();
            int dest = scanner.nextInt();
            g.addEdge(src, dest);
        }

        System.out.print("Enter the starting vertex for BFS: ");
        int startVertex = scanner.nextInt();

        System.out.println("Breadth First Traversal (starting from vertex " + startVertex + "):");
        g.BFS(startVertex);

        scanner.close();
    }
}