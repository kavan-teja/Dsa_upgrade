import java.util.*;
import java.util.LinkedList;
import java.util.Stack;

public class dfsdemo {
    private int V; // Number of vertices
    private LinkedList<Integer>[] adj; // Adjacency list representation

    @SuppressWarnings("unchecked")
    dfsdemo(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adj[i] = new LinkedList<>();
    }

    // Add an edge to the graph
    void addEdge(int v, int w) {
        adj[v].add(w);
    }

    // DFS traversal from a given source s
    void DFS(int s) {
        // Mark all the vertices as not visited
        boolean[] visited = new boolean[V];

        // Create a stack for DFS
        Stack<Integer> stack = new Stack<>();

        // Push the current source node
        stack.push(s);

        while (!stack.empty()) {
            // Pop a vertex from stack and print it
            s = stack.pop();

            // Stack may contain same vertex twice. So
            // we need to print the popped item only
            // if it is not visited.
            if (!visited[s]) {
                System.out.print(s + " ");
                visited[s] = true;
            }

            // Get all adjacent vertices of the popped vertex s
            // If an adjacent has not been visited, then push it
            // to the stack
            for (int i = adj[s].size() - 1; i >= 0; i--) {
                int v = adj[s].get(i);
                if (!visited[v])
                    stack.push(v);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of vertices: ");
        int V = scanner.nextInt();
        dfsdemo graph = new dfsdemo(V);

        System.out.println("Enter the edges (format: source destination, -1 -1 to end):");
        while (true) {
            int source = scanner.nextInt();
            int destination = scanner.nextInt();
            if (source == -1 && destination == -1) break;
            graph.addEdge(source, destination);
        }

        System.out.print("Enter the starting vertex for DFS: ");
        int startVertex = scanner.nextInt();

        System.out.println("Depth First Traversal (starting from vertex " + startVertex + "):");
        graph.DFS(startVertex);

        scanner.close();
    }
}