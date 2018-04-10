package Lab2;
/* Rongbo Guo
 * CIS313 
 * Lab2
 * 
 * We build BinarySearchTreein here
 * there is constitute by Insert, delete and InOrder Traverse.
 */

import java.util.Comparator;

public class BinarySearchTree <T extends Comparable<T>>{
	public Node<T> root;
	public Comparator<T> comparator;

	public BinarySearchTree(){
	   root = null;
	   comparator = null;
	}

	public BinarySearchTree (Comparator<T> compare){
	   root = null;
	   comparator = compare;
	}

	public int compare(T x, T y){
	   if(comparator == null) 
	       return x.compareTo(y);
	   else
		   return comparator.compare(x,y);
	}
	   
	//This is insert part to add element in to the Binary Tree
	public void insert(T data){
		root = insert(root, data);   
	}
	private Node<T> insert(Node<T> e, T toInsert){
		if(e == null){
			return new Node<T>(toInsert);
		}
		if(compare(toInsert, e.data) ==0){
		return e;			   
		}
		if(compare(toInsert, e.data) < 0){
			e.left = insert(e.left, toInsert);
		}
		else{
			e.right = insert(e.right, toInsert);
		}
		return e;			   
	}
	   
	//This is the search part to know can we find element we are input or not.
	public boolean search(T toSearch){
		return search(root, toSearch);
	}
	private boolean search(Node<T> e, T toSearch){
		if(e == null){
			return false;
		}
		if(compare(toSearch, e.data) == 0){
		return true;
		}
		else if(compare(toSearch, e.data) < 0){
			return search(e.left, toSearch);
		}
		else{
			return search(e.right, toSearch);
		}		   
	}
	   
	//This is the delete part to delete the element we are input form the Binary Tree.
	public boolean delete(T toDelete){
		root = delete(root, toDelete);
		return false;
	}
	private Node<T> delete(Node<T> e, T toDelete){
		if (e == null){
			throw new RuntimeException("cannot delete.");
	    }
		else if(compare(toDelete, e.data) < 0){
	    	e.left = delete (e.left, toDelete);
	    }
	    else if (compare(toDelete, e.data)  > 0){
	    	e.right = delete (e.right, toDelete);
	    }
	    else{
	    	if (e.left == null) 
	    		return e.right;
	    	else if (e.right == null) 
	    		return e.left;
	    	else{
	    	
	    		//we can get data at the rightmost node in the left subtree
	    		e.data = retrieveData(e.left);
	    		//we can delete the rightmost node from the left subtree
	    		e.left =  delete(e.left, e.data) ;
	    		}
	    	}
			return e;
	   }
	   private T retrieveData(Node<T> e){
		   while (e.right != null) e = e.right;
	       return e.data;
	   }
	   
	//This is the traverse part for inOrder
	public void inOrderTraverse(){
		inOrder(root);
	}
	private void inOrder(Node<T> r)
	{
	   if (r != null){
	      inOrder(r.left);
	      System.out.print(r+" ");
	      inOrder(r.right);
	      }
	}
}
