import java.util.*;
//number 3 final done sulat
public class GraphCycleDetector {
    private static class Graph {
        private final int vertices;
        private final List<List<Integer>> adjacencyList;

        public Graph(int vertices) {
            this.vertices = vertices;
            this.adjacencyList = new ArrayList<>(vertices);
            for (int i = 0; i < vertices; i++) {
                adjacencyList.add(new ArrayList<>());
            }
        }

        public void addEdge(int source, int destination) {
            adjacencyList.get(source).add(destination);
        }

        public boolean hasCycle() {
            boolean[] visited = new boolean[vertices];
            boolean[] recStack = new boolean[vertices];

            for (int i = 0; i < vertices; i++) {
                if (detectCycle(i, visited, recStack)) {
                    return true;
                }
            }
            return false;
        }

        private boolean detectCycle(int vertex, boolean[] visited, boolean[] recStack) {
            if (recStack[vertex]) {
                return true;
            }

            if (visited[vertex]) {
                return false;
            }

            visited[vertex] = true;
            recStack[vertex] = true;

            List<Integer> children = adjacencyList.get(vertex);
            for (Integer child : children) {
                if (detectCycle(child, visited, recStack)) {
                    return true;
                }
            }

            recStack[vertex] = false;
            return false;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter graph:");
        int numVertices = scanner.nextInt();
        Graph graph = new Graph(numVertices);

        while (scanner.hasNext()) {
            String edge = scanner.next();
            if (edge.equals("end")) {
                break;
            }
            edge = edge.replaceAll("[()]", ""); // Remove parentheses
            String[] parts = edge.split(",");
            int source = Integer.parseInt(parts[0]);
            int destination = Integer.parseInt(parts[1]);
            graph.addEdge(source, destination);
        }

        if (graph.hasCycle()) {
            System.out.println("Graph contains a cycle.");
        } else {
            System.out.println("Graph does not contain a cycle.");
        }
        scanner.close();
    }
}
