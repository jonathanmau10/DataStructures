
package unity2.trees;

import java.awt.Graphics;
import java.util.Stack;
import java.util.Vector;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

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
    
    public void recursivePrint(){
        recursivePrint(root);
        System.out.println();
    }
    
    private void recursivePrint(Node r){
        if(r == null)return;
        recursivePrint(r.left);//imprimir el lado izquierdo
        System.out.print(" "+r.data);//imprimir el root (cabecera)
        recursivePrint(r.right);//imprimi el lado derecho
    }
    
    public int recursiveCount(){
        return recursiveCount(root);       
    }
    
    private int recursiveCount(Node r){
        if(r == null) return 0;
        return recursiveCount(r.left) + recursiveCount(r.right) + 1;        
    }
    
    public int recursiveSum() {
        return recursiveSum(root);
    } 
    
    private int recursiveSum(Node r){
        if(r == null) return 0;
        return recursiveSum(r.left) + recursiveSum(r.right) + r.data;
    }
    
    public void PreOrderPrint(){        
        PreOrderPrint(root);
        System.out.println();
    }
    
    private void PreOrderPrint(Node r){
        if(r==null) return;
        System.out.println(" " + r.data);
        PreOrderPrint(r.left);
        PreOrderPrint(r.right);
    } 
    
     public void inOrderPrint(){        
        inOrderPrint(root);
        System.out.println();
    }
    
    private void inOrderPrint(Node r){
        if(r==null) return;
        inOrderPrint(r.left);
        System.out.println(" " + r.data);
        inOrderPrint(r.right);
    } 
    
     public void PostOrderPrint(){
        PostOrderPrint(root);
        System.out.println();
    }
    
    private void PostOrderPrint(Node r){
        if(r==null) return;
        PostOrderPrint(r.left);
        PostOrderPrint(r.right);
        System.out.println(" " + r.data);
    } 
    
    public void printLeafsR(){
        printLeafsR(root);
        System.out.println();
    }
    
    private void printLeafsR(Node r){
        if(r==null) return;
        if(r.left == null && r.right == null){
            System.out.println(" " + r.data);
            return;
        }
        printLeafsR(r.left);
        printLeafsR(r.right);
         
    }
    
    public int height (){
        return height(root);
    }
    
    
    public int height(Node node){
        if (node == null) {
            return 0;
        } else {
            return 1 + Math.max(height(node.left),height(node.right));                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 
        }
    }
    
    public void rDraw() {
        JFrame f = new JFrame() {
            public void paint(Graphics g) {
                g.clearRect(0, 0, getWidth(), getHeight());
                rDraw(root, 20, 40, g);
            }
        };
        f.setSize(600,400);
        f.setVisible(true);
        f.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    public void prune(){
        prune(root);
    }
    
    private void prune(Node r){
        if(r == null) return;
        if(r.left == null && r.right != null || r.left != null && r.right == null) {
            r.left = null;
            r.right = null;
        } 
        prune(r.left);
        prune(r.right);
    }
    
    public void complete(){
        complete(root);
    }
    
    private void complete(Node r){
        int d = 0;
        Node n;
        if(r == null) return;
        if(r.left == null && r.right != null) {
            n = new Node(r.data-1);
            r.left = n;
        } else if(r.left != null && r.right == null) {
            n = new Node(r.data+1);
            r.right = n;   
        } 
        complete(r.left);
        complete(r.right);
    }

    public boolean isComplete(){
        return isComplete(root);
    }    
    
    private boolean isComplete(Node r){
        if(r == null) return true;
        if(r.left == null && r.right != null || r.left != null && r.right == null){
            return false;
        } 
        
        return isComplete(r.left) && isComplete(r.right);
    }
    
    public Boolean exist(int d) {
        Node aux = root;
        if(d == root.data) return true;
        while(aux != null) {
            if(aux.data == d){
                return true; 
            } else if(d > aux.data){
                    aux = aux.right;
            } else if(d < aux.data) {
                    aux = aux.left;
            } 
        }
        return false;
    }
    
    public void invert(){
        invert(root);
    }
    
    private void invert(Node r){
        if(r == null) return;
        invert(r.left);
        invert(r.right);
        Node auxRight = r.right;
        Node auxLeft = r.left;
        r.left = auxRight;
        r.right = auxLeft;
    }
    
    public int countOdds(){
        return countOdds(root);
    }
    
    private int countOdds(Node r){
        if(r == null) return 0;
        int n = countOdds(r.left) + countOdds(r.right);
        if(r.data % 2 == 1) {
            return n + 1;
        } else {
            return n;
        }        
    }
    
    public void printSoonAlone(){
        printSoonAlone(root);
    }
    
    private void printSonsAlone(Node r){
        if(r == null) return;
        if(r.left == null && r.right != null) {
            System.out.println(" " + r.right.data);
        } else if(r.left != null && r.right == null) {
            System.out.println(" " + r.left.data);
        }
        printSonsAlone(r.left);
        printSonsAlone(r.right);
        
    }
    
    public void printMissing(){
        printMissing(root);
    }
    
    private void printMissing(Node r){
        if(r.left != null && r.right == null) {
            for(int i = r.left.data + 1 ; i < r.data; i++) {
                System.out.println(" " + i);
            }
        } else if(r.left == null && r.right != null){
            for(int i = r.data + 1; i < r.right.data; i++) {
                System.out.print(" " + i);
            }
        }
        printMissing(r.left);
        printMissing(r.right);
    }
    
    public void reversePrint(){
        reversePrint(root);
    }
    
    public void reversePrint(Node r){
      if(r==null) return;
      reversePrint(r.right);
      System.out.println(" "+r.data);
      reversePrint(r.left);
    }
    
    class Info {
        int xroot, xfinal;
    }
    
    private Info rDraw(Node r, int x, int y,Graphics g){
        Info rootInfo = new Info();
        rootInfo.xfinal = x;
        if(r == null) {
            return rootInfo;
        }
        Info leftInfo, rightInfo;
        
        leftInfo = rDraw(r.left, x, y+40,g);
        x = leftInfo.xfinal;
        
        g.drawOval(x, y, 30, 30);
        g.drawString("" + r.data, x+10, y+20);
        rootInfo.xroot = x;
        
        rightInfo = rDraw(r.right, x+30, y+40, g);
        rootInfo.xfinal = rightInfo.xfinal;
        
        if(r.left != null) {
            g.drawLine(rootInfo.xroot+5, y+25, leftInfo.xroot+15, y+50);
        }
        
        if(r.right != null) {
            g.drawLine(rootInfo.xroot+25, y+25, rightInfo.xroot+15, y+50);
        }
        return rootInfo;
        
    }
}
