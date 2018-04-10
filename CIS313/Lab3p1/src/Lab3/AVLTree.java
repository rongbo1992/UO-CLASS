package Lab3;
/* Rongbo Guo
 * CIS313 
 * Lab3 part1
 * 
 * We build AVL tree in here
 * there is constitute by Insert, delete and InOrder Traverse.
 */

public class AVLTree {   
	public Node root;	
	//This is insert part to add element in to the AVL tree
    public boolean insert(int key) {
        if (root == null)
            root = new Node(key, null);
        else {
            Node n = root;
            Node parent;
            while (true) {
                if (n.key == key)
                    return false;
                parent = n; 
                boolean goLeft = n.key > key;
                n = goLeft ? n.left : n.right;
                if (n == null) {
                    if (goLeft) {
                        parent.left = new Node(key, parent);
                    } else {
                        parent.right = new Node(key, parent);
                    }
                    rebalance(parent);
                    break;
                }
            }
        }
        return true;
    }
    
    //This is the search part to know can we find element we are input or not.
    public boolean search(int searKey){
    	if (root == null)
            root = new Node(searKey, null);
        else {
            Node n = root;
            Node parent;
            while (true) {
                if (n.key == searKey)
                    return true;
                parent = n;
                boolean goLeft = n.key > searKey;
                n = goLeft ? n.left : n.right;
                if (n == null) {
                    if (goLeft) {
                        parent.left = new Node(searKey, parent);
                    } else {
                        parent.right = new Node(searKey, parent);
                    }
                    rebalance(parent);
                    break;
                }
            }
        }
        return false;
    }    
    
    //This is the delete part to delete the element we are input form the AVL tree
    public void delete(int delKey) {
        if (root == null)
            return;
        Node n = root;
        Node parent = root;
        Node delNode = null;
        Node child = root;
 
        while (child != null) {
            parent = n;
            n = child;
            child = delKey >= n.key ? n.right : n.left;
            if (delKey == n.key)
                delNode = n;
        } 
        if (delNode != null) {
            delNode.key = n.key; 
            child = n.left != null ? n.left : n.right; 
            if (root.key == delKey) {
                root = child;
            } else {
                if (parent.left == n) {
                    parent.left = child;
                } else {
                    parent.right = child;
                }
                rebalance(parent);
            }
        }
    }
    
    //This is the balance part to make the AVL tree balance.
    private void rebalance(Node n) {
        setBalance(n);
 
        if (n.balance == -2) {
            if (height(n.left.left) >= height(n.left.right))
                n = rightRotate(n);
            else
                n = rotateLeftThenRight(n);
 
        } else if (n.balance == 2) {
            if (height(n.right.right) >= height(n.right.left))
                n = leftRotate(n);
            else
                n = rotateRightThenLeft(n);
        }
 
        if (n.parent != null) {
            rebalance(n.parent);
        } else {
            root = n;
        }
    }
 
    private Node leftRotate(Node a) {
        Node b = a.right;
        b.parent = a.parent;
        a.right = b.left; 
        if (a.right != null)
            a.right.parent = a; 
        b.left = a;
        a.parent = b; 
        if (b.parent != null) {
            if (b.parent.right == a) {
                b.parent.right = b;
            } else {
                b.parent.left = b;
            }
        }
        setBalance(a, b);
        return b;
    }
 
    private Node rightRotate(Node a) { 
        Node b = a.left;
        b.parent = a.parent;
        a.left = b.right;
        if (a.left != null)
            a.left.parent = a;
        b.right = a;
        a.parent = b;
        if (b.parent != null) {
            if (b.parent.right == a) {
                b.parent.right = b;
            } else {
                b.parent.left = b;
            }
        }
        setBalance(a, b);
        return b;
    }
 
    private Node rotateLeftThenRight(Node n) {
        n.left = leftRotate(n.left);
        return rightRotate(n);
    }
 
    private Node rotateRightThenLeft(Node n) {
        n.right = rightRotate(n.right);
        return leftRotate(n);
    }
 
    private int height(Node n) {
        if (n == null)
            return -1;
        return 1 + Math.max(height(n.left), height(n.right));
    }
 
    private void setBalance(Node... nodes) {
        for (Node n : nodes)
            n.balance = height(n.right) - height(n.left);
    }
 
    public void inOrderTraverse() {
    	inOrderTraverse(root);
    }
 
    private void inOrderTraverse(Node n) {
        if (n != null) {
        	inOrderTraverse(n.left);
            System.out.printf("%s ", n.key);
            inOrderTraverse(n.right);
        }
    }
}