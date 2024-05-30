import java.util.*;
//number 8 final done sulat
public class GraphIsomorphism {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter the vertices of the first graph (space-separated):");
        String[] vertices1 = scanner.nextLine().split(" ");
        
        System.out.println("Enter the vertices of the second graph (space-separated):");
        String[] vertices2 = scanner.nextLine().split(" ");
        
        boolean isIsomorphic = checkIsomorphism(vertices1, vertices2);
        
        if (isIsomorphic) {
            System.out.println("The graph is possibly isomorphic.");
        } else {
            System.out.println("The graph is not isomorphic.");
        }
        
        scanner.close();
    }
    
    private static boolean checkIsomorphism(String[] vertices1, String[] vertices2) {
        
        return vertices1.length == vertices2.length;
    }
}
