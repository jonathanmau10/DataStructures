
package unity2.trees;

/**
 *
 * @author jonathan
 */
public class Node {
    
    protected int data;
    protected Node left;
    protected Node right;
    
    public Node(int d) {
        data = d;
        left = right = null;
    }
}
