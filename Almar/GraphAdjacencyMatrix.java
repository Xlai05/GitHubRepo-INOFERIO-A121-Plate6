import java.util.*;
//num 6 done sulat
public class GraphAdjacencyMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int n = scanner.nextInt();
        
        int[][] adjacencyMatrix = new int[n][n];
        
        while (scanner.hasNext()) {
            String input = scanner.next();
            if (input.equals("end")) break;
            
            int vertex1 = Character.getNumericValue(input.charAt(1));
            int vertex2 = Character.getNumericValue(input.charAt(3));
            
            adjacencyMatrix[vertex1][vertex2]++;
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(adjacencyMatrix[i][j] + " ");
            }
            System.out.println();
        }
        
        scanner.close();
    }
}
