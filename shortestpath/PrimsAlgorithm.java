package shortestpath;
import java.util.Arrays;
public class PrimsAlgorithm {
    static int minKey(int[] key, boolean[] mstSet, int n) {
        int min = Integer.MAX_VALUE;
        int minIndex = -1;

        for (int v = 0; v < n; v++) {
            if (!mstSet[v] && key[v] < min) {
                min = key[v];
                minIndex = v;
            }
        }
        return minIndex;
    }

    // Method to perform Prim's algorithm
    public static void primsMST(int[][] graph, int n) {
        int[] parent = new int[n];  // Array to store the parent of each vertex in the MST
        int[] key = new int[n];     // Array to store the minimum weight edge that connects each vertex to the MST
        boolean[] mstSet = new boolean[n];  // Array to track which vertices are included in the MST

        // Initialize all keys as infinity and mstSet as false
        Arrays.fill(key, Integer.MAX_VALUE);
        Arrays.fill(mstSet, false);

        // Start from the first vertex
        key[0] = 0;  // The first vertex has the minimum key value

        parent[0] = -1;  // The first node does not have a parent (it is the root)

        for (int count = 0; count < n - 1; count++) {
            // Choose the minimum key vertex from the set of vertices not yet included in the MST
            int u = minKey(key, mstSet, n);

            // Include this vertex in the MST set
            mstSet[u] = true;

            // Update the key and parent values of the adjacent vertices of the chosen vertex
            for (int v = 0; v < n; v++) {
                if (graph[u][v] != 0 && !mstSet[v] && graph[u][v] < key[v]) {
                    key[v] = graph[u][v];
                    parent[v] = u;
                }
            }
        }

        // Print the MST
        printMST(parent, graph);
    }

    // A utility method to print the constructed MST
    public static void printMST(int[] parent, int[][] graph) {
        System.out.println("Edge \tWeight");
        for (int i = 1; i < parent.length; i++) {
            System.out.println(parent[i] + " - " + i + "\t" + graph[i][parent[i]]);
        }
    }

    public static void main(String[] args) {
        // Example graph represented as an adjacency matrix
        // graph[u][v] = weight of edge from u to v, 0 means no edge
        int[][] graph = {
                {0, 2, 0, 6, 0},
                {2, 0, 3, 8, 5},
                {0, 3, 0, 0, 7},
                {6, 8, 0, 0, 9},
                {0, 5, 7, 9, 0}
        };

        // Run Prim's algorithm on the graph with 5 vertices
        primsMST(graph, 5);
    }
}
