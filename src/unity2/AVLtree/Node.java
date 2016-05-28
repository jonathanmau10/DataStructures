
package unity2.AVLtree;

/**
 *
 * @author jonathan
 */
public class Node {
    protected Node root;
    protected int data;
    protected int height;
    protected Node left;
    protected Node right;

    public Node(int d) {
        this.data = d;
        height = 1;
        left = right = null;
    }
}
