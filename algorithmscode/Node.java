import java.util.ArrayList;


public class Node {
    ArrayList<Node>  adj;  // linked list of pointers to adjacent nodes 
    ArrayList<Edge> adjEdges; // pointers to the edges corresponding to the nodes in the adjacency list
    int d;  // distance from root in BFS, discovery time in DFS
} 