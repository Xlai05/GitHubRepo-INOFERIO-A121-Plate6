import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

//number 2 final done sulat
public class AdjacencyMatrixEdges {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of vertices: ");
        int V = scanner.nextInt();

        int[][] adjMatrix = new int[V][V];

        System.out.println("Enter the adjacency matrix:");
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                adjMatrix[i][j] = scanner.nextInt();
            }
        }

        Map<String, Integer> edgeCount = new HashMap<>();

        System.out.println("Edges and their counts:");
        for (int i = 0; i < V; i++) {
            for (int j = i; j < V; j++) {
                if (adjMatrix[i][j] > 0) {
                    String edge = i + "-" + j;
                    edgeCount.put(edge, adjMatrix[i][j]);
                }
            }
        }

        for (Map.Entry<String, Integer> entry : edgeCount.entrySet()) {
            System.out.println("Edge " + entry.getKey() + " appears " + entry.getValue() + " times.");
        }

        scanner.close();
    }
}
