/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unity2.AVLtree;

/**
 *
 * @author jonathan
 */
public class Tree {
    
    private Node root;
    
    public Tree() {
        root = null;
    }

    private Node leftRotate(Node r) {
        Node aux = r;
        aux = r.right;
        r.right = aux.left;
        aux.left = r;
        r.height = Math.max(height(r.left), height(r.right)) + 1;
        aux.height = Math.max(height(aux.left), height(aux.right)) + 1;
        return r;
    }

    private Node rightRotate(Node r) {
        Node aux = r;
        aux = r.left;
        r.left = aux.right;
        aux.right = r;
        r.height = Math.max(height(r.left), height(r.right)) + 1;
        aux.height = Math.max(height(aux.left), height(aux.right)) + 1;
        return r;
    }

    private int equilibriumFactor(Node r) {
        if (r == null) {
            return 0;
        }
        return height(r.left) - height(r.right);
    }

    private int height(Node r) {
        if (r == null) {
            return 0;
        }
        return r.height;
    }
}
