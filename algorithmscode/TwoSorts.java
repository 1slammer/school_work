
import java.util.*;

public class TwoSorts {
  private static int numComp = 0;
//main driver program
public static void main(String[] args){

  Scanner scan = new Scanner(System.in);
  String first = scan.nextLine();
  if (first.contains(".")){
    //do bucket sort
    ArrayList<Double> dubArray = new ArrayList<Double>();
    dubArray.add(Double.parseDouble(first));
    while (scan.hasNextLine()) {
      double js = Double.parseDouble(scan.nextLine());
      if(js == -1)break;
      dubArray.add(js);
    }
    double[] newDubArr = new double[dubArray.size()];
    for (int x = 0; x< dubArray.size(); x++){
      newDubArr[x] = dubArray.get(x);
    }
    double[] newArr = BucketSort(newDubArr);
    for (int x=0; x< newArr.length; x++){
      System.out.println("jzn0016 bucket #" + (x+1) + ": " + newArr[x]);
    }
    System.out.println("jzn0016 bucket comparisons: " + numComp);
  }
  else {
    //do counting sort
    ArrayList<Integer> intArray = new ArrayList<Integer>();
    intArray.add(Integer.parseInt(first));
    while (scan.hasNextLine()) {
      int js = Integer.parseInt(scan.nextLine());
      if(js == -1)break;
      intArray.add(js);
  }
    int[] newIntArr = new int[intArray.size()];
    for (int x = 0; x< newIntArr.length; x++){
      newIntArr[x] = intArray.get(x);
    }
    int[] finalArr = CountingSort(newIntArr, new int[newIntArr.length], 100);
    for (int x=0; x< finalArr.length; x++){
      System.out.println("jzn0016 counting #" + (x+1) + ": " + finalArr[x]);
    }

}
}
  public static int[] CountingSort(int A[], int B[], int k){
    int[] C = new int[k];
    for (int i = 0; i< k; i++){
      C[i] = 0;
    }
    for (int j = 0; j< A.length; j++){
      C[A[j]] = C[A[j]] + 1;
    }
    for(int i = 1; i < k; i++){
      C[i] = C[i] + C[i-1];
    }
    for(int j=A.length-1; j>-1;j--){
      B[C[A[j]]-1] = A[j];
      C[A[j]] = C[A[j]]-1;
    }
    return B;

  }
  public static double[] BucketSort(double[] A){
    int n = A.length;
    //new Array
    NodeList[] B = new NodeList[n];
    //initialize empty lists
    for (int x = 0; x< n; x++){
      B[x] = new NodeList();
    }
    //insert A[i] into the list
    for (int x=0; x< n; x++){
      B[(int)Math.floor(A[x]*n)].addNode(new Node(A[x]));
    }
    //perform insertion sort on each list
    for (int x = 0; x<n; x++){
      B[x].sort();
    }
    //concatenate the lists
    int y = 0;
    for (int x = 0; x< n; x++){
        Node temp = B[x].head;
        while(temp != null){
          A[y] = temp.value;
          temp = temp.next;
          y++;
        }
    }
    //return the list
    return A;
  }
  //supporting classes
  private static class NodeList{
  Node head;
  int length;

  public NodeList(){
    head = null;
  }
  public void addNode(Node nodeIn){
    if(head == null){
      head = nodeIn;
      return;
    }
    if(head.next == null){
    head.next = nodeIn;
    return;
  }
  Node temp = head.next;
    while(temp.next != null){
      temp = temp.next;
    }
    temp.next = nodeIn;
  }
  public void sort(){
    if (head == null || head.next == null) return;
    Node newHead = new Node(head.value);
    Node pointer = head.next;
    while(pointer != null){
      Node x = newHead;
      Node y = pointer.next;
      if(pointer.value < newHead.value){
        numComp++;
        Node z = newHead;
        newHead = pointer;
        newHead.next = z;
      }
      else {
        while(x.next != null){
          if(pointer.value > x.value && pointer.value <= x.next.value){
            numComp++;
            Node oldNext = x.next;
            x.next = pointer;
            pointer.next = oldNext;
          }
          x = x.next;
        }
        if(x.next == null && pointer.value >x.value){
          numComp++;
          x.next = pointer;
          pointer.next = null;
        }
      }
      pointer = y;
    }
    this.head = newHead;
  }
}


private static class Node {
  Node next;
  double value;

  public Node(){
    next = null;
    value = 0.0;
  }
  public Node(double va){
    value = va;
    next = null;
  }

  public void setValue(double valIn){
    value = valIn;

  }
  public double getValue(){
    return value;
  }
  public void setNext(Node nextIn){
    next = nextIn;

  }
}


}