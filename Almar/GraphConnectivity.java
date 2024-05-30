import java.util.*;
// number 1 final
public class GraphConnectivity {
    private int V;
    private LinkedList<Integer> adj[];

    @SuppressWarnings("unchecked")
    public GraphConnectivity(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adj[i] = new LinkedList<>();
    }

    void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
    }

    void DFSUtil(int v, boolean visited[]) {
        visited[v] = true;
        for (Integer n : adj[v]) {
            if (!visited[n])
                DFSUtil(n, visited);
        }
    }

    boolean isConnected() {
        boolean visited[] = new boolean[V];
        int count = 0;
        for (int i = 0; i < V; ++i) {
            if (!visited[i]) {
                DFSUtil(i, visited);
                count++;
            }
        }
        return count == 1;
    }

    void connectedComponents() {
        boolean visited[] = new boolean[V];
        int count = 0;
        for (int i = 0; i < V; ++i) {
            if (!visited[i]) {
                DFSUtil(i, visited);
                count++;
            }
        }
        System.out.println("Number of connected components: " + count);
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of vertices: ");
        int V = scanner.nextInt();
        GraphConnectivity graph = new GraphConnectivity(V);
        System.out.println("Enter the edges (vertex1 vertex2), type 'end' to finish: ");
        while (scanner.hasNext()) {
            if(scanner.hasNext("end")) {
                break;
            }
            int v = scanner.nextInt();
            int w = scanner.nextInt();
            graph.addEdge(v, w);
        }
        scanner.close();

        if (graph.isConnected()) {
            System.out.println("The graph is connected.");
        } else {
            System.out.println("The graph is not connected.");
            graph.connectedComponents();
        }
    }
}
