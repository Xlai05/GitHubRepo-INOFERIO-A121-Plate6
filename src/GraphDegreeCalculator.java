import java.util.*;
//4 done sulat
public class GraphDegreeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter graph:");

        
        int numVertices = scanner.nextInt();
        int[] degrees = new int[numVertices];

        while (scanner.hasNext()) {
            String edge = scanner.next();
            if (edge.equals("end")) {
                break;
            }
            edge = edge.replaceAll("[()]", ""); 
            String[] parts = edge.split(",");
            int vertex1 = Integer.parseInt(parts[0]);
            int vertex2 = Integer.parseInt(parts[1]);

            
            degrees[vertex1]++;
            degrees[vertex2]++;
        }

        System.out.println("Degree of each vertex:");
        for (int i = 0; i < numVertices; i++) {
            System.out.println("Vertex " + i + " has degree " + degrees[i]);
        }

        scanner.close();
    }
}
