package Lab2;
/* Rongbo Guo
 * CIS313 
 * Lab2
 * 
 * This is the Node code to 
 * node for binary search tree
 */

public class Node<T>{
   public T data;
   public Node<T> left, right;
   public Node(T data, Node<T> l, Node<T> r){
      this.data = data;
   }
   public Node(T data){
      this(data, null, null);
   }
   public String toString(){
      return data.toString();
   }
} //end of Node
