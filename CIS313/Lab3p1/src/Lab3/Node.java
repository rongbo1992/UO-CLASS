package Lab3;
/* Rongbo Guo
 * CIS313 
 * Lab3
 * 
 * This is the Node code to 
 * node for AVL tree
 */

public class Node {
    int key;
    int balance;
    Node left, right, parent;

    Node(int k, Node p) {
        key = k;
        parent = p;
    }
}
