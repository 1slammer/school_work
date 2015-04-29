import java.util.Scanner;
import java.util.LinkedList;
import java.util.Set;
import java.util.HashSet;
import java.util.ArrayList;

public class prog3 { 
    int MAX_VALUE = Integer.MAX_VALUE; 
    int INFINITY = 11000;
    Scanner scanner = new Scanner(System.in);
    Graph G = new Graph(); 
    public Set<Set<Node>> nodeSet = new HashSet<Set<Node>>();  // set of sets of nodes for Kruskal's algorithm 

    public static void main(String args[]) { 
  new prog3().run();
    } 

    public Graph MST_KRUSKAL(Graph G) {
  // implement Kruskal's algorithm here 
    }

    // utility functions for sets of nodes 
    public Set<Node> UNION(Node u, Node v) { 
  // implement UNION here
    }

    public Set<Node>  MAKESET(Node u) { 
  // implement MAKESET here
    }
 
    
    public Set<Node>  FINDSET(Node u) {
  // implement FINDSET here
    }
    

    public void run() {
  // process input, first line is number of nodes, followed by number of edges, 
  // then each line has one edge, with tail first, then head, then weight
        int numNodes = scanner.nextInt();
        int numEdges = scanner.nextInt();
  //System.out.println("numNodes="+numNodes+" numEdges="+numEdges);
  // create the  nodes
  for(int j = 1; j <=  numNodes ; j++) { 
      //System.out.println("added node "+j);
      Node n = G.addNode();
  }

  // process the edges in the input; 
  for (int j = 1; j <= numEdges; j++) {
      int headNum = scanner.nextInt();
      int tailNum = scanner.nextInt();
      int weight = scanner.nextInt();
      //System.out.println("added edge head="+headNum+" tail="+tailNum);
      Node head = G.nodeList.get(headNum);
      Node tail = G.nodeList.get(tailNum);
      G.addEdge(head,tail,weight); 
        }


        // test print it out 
  //G.print(); 
  Graph T = MST_KRUSKAL(G);  // compute the MST by Kruskal's agorithm

  T.print();  // generate output
    }

}