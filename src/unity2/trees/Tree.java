
package unity2.trees;

import java.util.Stack;
import java.util.Vector;

/**
 *
 * @author jonathan
 */
public class Tree {
    private Node root;
    
    public Tree() {
        root = null;
    }
    
    public void add(int d) {
        Node n = new Node(d);
        if(root == null) {
            root = n;
        } else {
            Node aux = root, p = null;
            while(aux != null) {
                if(d < aux.data) {
                    p = aux;
                    aux = aux.left;
                } else if(d > aux.data) {
                    p = aux;
                    aux = aux.right;
                } else {
                    return;
                }
            }
            if(d < p.data) {
                p.left = n;
            } else {
                p.right = n;
            }
        } 
    }
    
     public void print(){
        Node aux=root;
        Stack <Node> s = new Stack <Node> ();
        while(aux!=null){
            s.push(aux);
            aux=aux.left;
        }
        while(!s.empty()){
            aux=s.pop();
            System.out.println(""+aux.data);
            aux=aux.right;
            while(aux!=null){
                s.push(aux);
                aux=aux.left;
            }
        }
    }    
     
     public void printPath(int d){
        Vector<Node> path = new Vector<Node>();
        Node aux = root;
        while(aux != null) {
            path.add(aux);
            if(d > aux.data) {
                aux = aux.right;
            } else if(d < aux.data) {
                aux = aux.left;
            } else {
                for (int i = 0; i < path.size(); i++) {
                    System.out.println(" "+path.elementAt(i).data);
                }
                System.out.println();
                return;
            }
        }
        System.out.println("Doesn't exist ");
    }
    
    public boolean isleaf (int d){
        Node aux = root;
        while(aux != null){
            if(d > aux.data){
                aux = aux.right;
            } else if(d < aux.data) {
                aux = aux.left;
            } else {
                if(aux.right == null && aux.left == null){
                return true;
            } else {
                    return false;
                }
            }
        }
        return false;
    }
    public int count(){
        int cont=0;
        Node aux=root;
        Stack <Node> s = new Stack <Node> ();
        while(aux!=null){
            s.push(aux);
            aux=aux.left;
        }
        while(!s.empty()){
            aux=s.pop();
            cont++;
            aux=aux.right;
            while(aux!=null){
                s.push(aux);
                aux=aux.left;
            }
        }
        return cont;
    }
    
    public void printLeafs(){
        Node aux = root;
        Stack <Node> s = new Stack <Node> ();
        while(aux != null) {
            s.push(aux);
            aux = aux.left;
        }
        while(!s.empty()) {
            aux = s.pop();
            aux = aux.right;
            if(aux.left == null && aux.right == null) {
                System.out.println(" "+aux.data);
            }
            while(aux != null) {
                s.push(aux);
                aux = aux.left;
            }
        }
    }
    
    public int max(){
        if(root==null)return -1;
        Node aux=root;
        while(aux.right!=null){
            aux=aux.right;
        }
        return aux.data;
    }
    
    public int min(){
        if(root==null)return -1;
        Node aux=root;
        while(aux.left!=null) {
            aux=aux.left;
        }
        return aux.data;
    }
}
