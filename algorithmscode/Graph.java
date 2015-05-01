import java.util.ArrayList;



public class Graph { 
    // Nodes are numbered 1,2,...,numNodes;
    // There IS a node zero, but it is never used
    // The .size() function on nodeList and edgeList DOES NOT return the number of nodes or edges
    // use numNodes and numEdges instead
    public ArrayList<Node> nodeList;
    public ArrayList<Edge> edgeList; 
    public int numNodes = 0;
    public int numEdges = 0;

    public Graph() { 
  nodeList = new ArrayList<Node>();
  edgeList = new ArrayList<Edge>();
  Node n = new Node();
  nodeList.add(n);
  Edge e = new Edge();
  edgeList.add(e);
    } 


    public Node addNode() { 
  Node n = new Node();
  nodeList.add(n);
  numNodes++;
  n.adj = new ArrayList<Node>();
  n.adjEdges = new ArrayList<Edge>();
  //System.out.println("nodeList.size="+nodeList.size());
  return n;
    }

    public Edge addEdge(Node u, Node v,int w) {
  u.adj.add(v);
  Edge e = new Edge();
  e.head = u; 
  e.tail = v;
  e.weight = w; 
  numEdges++;
  edgeList.add(e);
  u.adjEdges.add(e);
  return e;
    } 


    public void print() { 
        //  print out the graph to verify it is correctly read, using the adj list
  // print the number of nodes and edges
  System.out.println((nodeList.size()-1)+" "+(edgeList.size()-1));
  for (Node u: nodeList) { 
            // have to handle the null zero node 
            if (nodeList.indexOf(u) != 0) {  
          for (Node v: u.adj) { 
        System.out.println(nodeList.indexOf(u)+" "+nodeList.indexOf(v)+" "+u.adjEdges.get(u.adj.indexOf(v)).weight);
          } 
      }
  } 
    }

}