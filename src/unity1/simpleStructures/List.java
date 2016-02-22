
package unity1.simpleStructures;

import unity1.simpleStructures.Node;

/**
 *
 * @author jonathan
 */
public class List {
    private Node head;
    
    List(){
        head = null;
    }
    
    public void add(int d){
        Node n = new Node(d);
        if(head == null){
            head = n;
        }
        else{
            Node aux = head;
            while(aux.next != null){
                aux = aux.next;
            }
            aux.next = n;
        }
    }
    
    
    public int count(){
        int count = 0;
        Node aux = head;
        
        while(aux != null){
            count++;
            aux = aux.next;
        }
        
        return count;
    }
    
    public void printFirstElement(){
        Node aux = head;
        if(aux == null){
            System.out.println(-1);
        }
        else{
            System.out.println(aux.data);
        }
    }
    
    public void printLastElement(){
            Node aux = head;
            while(aux.next != null){
                aux = aux.next;
            }
            int elem = aux.data;
            System.out.println(elem);
        
    }
    
    
    public void print(){
        Node aux = head;
        
        while(aux != null){
            System.out.print(" " + aux.data);
            aux = aux.next;
        }
        
        System.out.println();
    }
    
    public int remove(int index){
        if(head == null){return -1;}
            if(index == 0){
                head = head.next;
                return 0;
            }

            Node aux = head;
            Node p = null;
            int counter = 0;
            for(counter = 0; counter < index && aux != null; counter++){
                p = aux;
                aux = aux.next;
            }
            
            if(aux != null){
                p.next = aux.next;
            }
            return aux.data;
    }
    
    public void removeFirstElement(){
        if(head != null){
            head = head.next;
        }
    }
    
    public void removeLastElement(){
        if(head != null){
            Node aux = head;
            Node p = null;
            if(head.next == null){
                head = head.next;
            }
            else{
                while(aux.next != null){
                    p = aux;
                    aux = aux.next;
                }
                p.next = aux.next;
            }
        }
    }
}
