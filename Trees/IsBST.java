/**
 * Write a program to check whether a root forms a BST or not.
 *
 * Solution1: (Implemented here): Do an in-order traveral, which would tell
 *            if something is out of order.
 *
 * Solution2: Problem with solution 1 is for each root, entire left tree is explored
 *            first and then we start looking in the right, which is O(n) everytime.
 *            We can use level wise traversal using queues. Each element in the queue
 *            would also store min and max value it could have, basically the range.
 *            If number goes out of range, then shout.
 *
 */

class Node<Item> {
    public Item t;
    Node<Item> left, right;

    Node(Item t) {
        this.t = t;
        this.left = null;
        this.right = null;
    }
}

public class IsBST {
    static Integer max = null;
    public static boolean check(Node<Integer> node) {
        // Kind of do an in-order traversal, which would
        // tell whether a node is present out of order.
        if (node == null) { return true; }
        
        boolean l_tree=true, r_tree=true;
        if (node.left != null) {
            l_tree = check(node.left); 
        }
        if (max != null) {
            if (node.t < max) {
                return false;
            } else {
                max = node.t;
                if (node.right != null) {
                    r_tree = check(node.right);
                }
                return l_tree && r_tree;
            }
        } else {
            max = node.t;
            return true;
        }
    }

    public static void main(String[] args) {
        Node<Integer> n5 = new Node<Integer>(5);
        Node<Integer> n3 = new Node<Integer>(3);
        Node<Integer> n8 = new Node<Integer>(8);
        Node<Integer> n1 = new Node<Integer>(1);
        Node<Integer> n4 = new Node<Integer>(4);

        Node<Integer> n2 = new Node<Integer>(2);
        Node<Integer> n9 = new Node<Integer>(9);

        n5.left = n3;
        n5.right = n8;
        n3.left = n1;
        n3.right = n4;

        System.out.println(IsBST.check(n5));

        n8.left = n2;
        n8.right = n9;

        System.out.println(IsBST.check(n5));
    }
}

