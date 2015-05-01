import java.util.*;

public class Edge implements Comparable<Edge> { 
    Node head; 
    Node tail;
    int weight; 

    @Override
    public int compareTo(Edge o){
    	return (this.weight - o.weight);
    }
} 