import java.util.*;
//final 5
public class BipartiteGraph {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter the number of vertices:");
        int numVertices = scanner.nextInt();
        
        List<int[]> edges = new ArrayList<>();
        System.out.println("Enter the edges in the format u,v and type 'end' to stop:");

        while (scanner.hasNext()) {
            String input = scanner.next();
            if (input.equalsIgnoreCase("end")) {
                break;
            }
            String[] vertices = input.split(",");
            int u = Integer.parseInt(vertices[0]);
            int v = Integer.parseInt(vertices[1]);
            edges.add(new int[]{u, v});
        }
        
        if (isBipartite(numVertices, edges)) {
            System.out.println("The graph is bipartite.");
        } else {
            System.out.println("The graph is not bipartite.");
        }
        
        scanner.close();
    }

    private static boolean isBipartite(int numVertices, List<int[]> edges) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numVertices; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        
        int[] colors = new int[numVertices];
        Arrays.fill(colors, -1);
        
        for (int i = 0; i < numVertices; i++) {
            if (colors[i] == -1) {
                if (!bfsCheck(graph, i, colors)) {
                    return false;
                }
            }
        }
        
        return true;
    }

    private static boolean bfsCheck(List<List<Integer>> graph, int start, int[] colors) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        colors[start] = 0;
        
        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int neighbor : graph.get(node)) {
                if (colors[neighbor] == -1) {
                    colors[neighbor] = 1 - colors[node];
                    queue.offer(neighbor);
                } else if (colors[neighbor] == colors[node]) {
                    return false;
                }
            }
        }
        
        return true;
    }
}
