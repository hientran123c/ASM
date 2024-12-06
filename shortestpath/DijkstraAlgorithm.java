package shortestpath;

import java.util.Arrays;
import java.util.PriorityQueue;
public class DijkstraAlgorithm {
    static class Vertex implements Comparable<Vertex> {
        int id;
        int distance;

        public Vertex(int id, int distance) {
            this.id = id;
            this.distance = distance;
        }

        @Override
        public int compareTo(Vertex other) {
            return Integer.compare(this.distance, other.distance);
        }
    }

    // A method to perform Dijkstra's algorithm to find the shortest path
    public static void dijkstra(int[][] graph, int source) {
        int n = graph.length;
        int[] dist = new int[n];  // Array to hold the shortest distance from the source to each vertex
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[source] = 0;  // Distance from source to source is 0

        // Priority queue to process vertices with the smallest distance first
        PriorityQueue<Vertex> pq = new PriorityQueue<>();
        pq.add(new Vertex(source, 0));

        while (!pq.isEmpty()) {
            Vertex u = pq.poll();  // Get the vertex with the minimum distance

            // Iterate over each neighbor of the current vertex
            for (int v = 0; v < n; v++) {
                if (graph[u.id][v] != 0) {  // There is an edge between u and v
                    int newDist = u.distance + graph[u.id][v];
                    if (newDist < dist[v]) {
                        dist[v] = newDist;
                        pq.add(new Vertex(v, dist[v]));  // Add the vertex with the updated distance to the queue
                    }
                }
            }
        }

        // Print the shortest distance from source to each vertex
        System.out.println("Shortest distances from source vertex " + source + ":");
        for (int i = 0; i < n; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                System.out.println("Vertex " + i + " is unreachable");
            } else {
                System.out.println("Vertex " + i + ": " + dist[i]);
            }
        }
    }

    public static void main(String[] args) {
        // Example graph represented as an adjacency matrix
        // graph[u][v] = weight of edge from u to v, 0 means no edge
        int[][] graph = {
                {0, 7, 9, 0, 0, 0},
                {7, 0, 10, 15, 0, 0},
                {9, 10, 0, 11, 0, 0},
                {0, 15, 11, 0, 6, 0},
                {0, 0, 0, 6, 0, 9},
                {0, 0, 0, 0, 9, 0}
        };

        // Run Dijkstra's algorithm from vertex 0
        dijkstra(graph, 0);
    }
}
