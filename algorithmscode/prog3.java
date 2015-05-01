import java.util.*;

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
      //Set<Edge> A = new HashSet<Edge>();
      Graph mg = new Graph();
      mg.nodeList = G.nodeList;
      mg.numNodes = G.numNodes;
        for(Node k: mg.nodeList) {
          k.adj = new ArrayList<Node>();
          k.adjEdges = new ArrayList<Edge>();
        }
       

        for (Node n : G.nodeList){
          MAKESET(n);
        } 
        Collections.sort(G.edgeList, new Comparator<Edge>() {
          @Override
          public int compare(Edge e1, Edge e2) {
            return e1.weight - e2.weight;
          }
        });
        for (Edge e: G.edgeList){
          if (e.head != null && e.tail != null){
          if (FINDSET(e.head) != (FINDSET(e.tail))){
            
              mg.addEdge(e.head, e.tail, e.weight);

              Set<Node> newSet = UNION(e.head, e.tail);
              nodeSet.add(newSet);

          }
        }
        }
          /*ArrayList<Edge> edges = new ArrayList<Edge>();
          ArrayList<Node> nodes = new ArrayList<Node>();
          for (Edge p: A) edges.add(p);
          for (Edge p: A) { if(!(nodes.contains(p.head)))
            nodes.add(p.head);
            if(!(nodes.contains(p.tail)))
            nodes.add(p.tail);
          }*/
        
        return mg;
  }
    // utility functions for sets of nodes 
    public Set<Node> UNION(Node u, Node v) { 
  // implement UNION here
      Set<Node> temp1 = new HashSet<Node>();
      Set<Node> temp2 = new HashSet<Node>();
      for(Set s: nodeSet){
        if (s.contains(u)){ temp1 = s;
           
        }
        if (s.contains(v)) {temp2 = s;
        }
      }
        boolean x = nodeSet.remove(temp1);
        boolean y = nodeSet.remove(temp2);
        temp1.addAll(temp2);
        return temp1;

    }

    public Set<Node>  MAKESET(Node u) { 
  // implement MAKESET here
      Set<Node> temp = new HashSet<Node>();
      temp.add(u);
      nodeSet.add(temp);
    
    return temp;
    }
    
    public Set<Node>  FINDSET(Node u) {
  // implement FINDSET here
      for(Set<Node> s: nodeSet){
        if (s.contains(u)) return s;
              }
      return null;
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