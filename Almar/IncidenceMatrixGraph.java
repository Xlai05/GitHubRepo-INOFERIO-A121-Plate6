import java.util.*;
//final 7 done sulat
public class IncidenceMatrixGraph {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of vertices:");
        int numVertices = scanner.nextInt();
        scanner.nextLine(); 

        List<Edge> edges = new ArrayList<>();
        System.out.println("Enter the edges in the format u,v count and type 'end' to stop:");

        while (scanner.hasNextLine()) {
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("end")) {
                break;
            }

            String[] parts = input.split(" ");
            String edgeStr = parts[0];
            int count = Integer.parseInt(parts[1]);

            String[] vertices = edgeStr.split(",");
            int u = Integer.parseInt(vertices[0]);
            int v = Integer.parseInt(vertices[1]);

            for (int i = 0; i < count; i++) {
                edges.add(new Edge(u, v));
            }
        }

        int numEdges = edges.size();
        int[][] incidenceMatrix = new int[numVertices][numEdges];

        for (int i = 0; i < numEdges; i++) {
            Edge edge = edges.get(i);
            if(edge.u < numVertices && edge.v < numVertices) {
                incidenceMatrix[edge.u][i] = 1;
                incidenceMatrix[edge.v][i] = 1;
            } else {
                System.out.println("Invalid edge detected: " + edge.u + ", " + edge.v);
            }
        }

        System.out.println("The incidence matrix is:");
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numEdges; j++) {
                System.out.print(incidenceMatrix[i][j] + " ");
            }
            System.out.println();
        }

        scanner.close();
    }

    static class Edge {
        int u, v;

        Edge(int u, int v) {
            this.u = u;
            this.v = v;
        }
    }
}
