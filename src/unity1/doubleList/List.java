
package unity1.doubleList;

/**
 *
 * @author jonathan
 */
public class List {
    private Node head;
    
    public List(){
        head = null;        
    }
    
    public void add(int d){
        Node n = new Node(d);
        if (head == null) {
            head = n;
        }else{
            Node aux = head;
            while(aux.next != null){
                aux = aux.next;
            }
            aux.next = n;
            n.back = aux;
        }
    }
    public void print(){
        Node aux = head;
        while(aux != null){
            System.out.print(" "+aux.data);
            aux = aux.next;
        }
        System.out.println();
    }
    public void reversePrint(){
        if(head == null) return;
        Node aux = head;
        while(aux.next != null){
            aux = aux.next;
        }
        while(aux != null){
            System.out.print(" "+aux.data);
            aux = aux.back;
        }
        System.out.println();
    }
    public void push(int d){
        Node n = new Node(d);
        if (head == null) {
            head = n;
        }else{
            n.next = head;
            head.back = n;
            head = n;
        }
    }
    
    public void removeLast(){
        
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
    
    public void removeFirst(){
        if(head == null) return;
        head = head.next;
        head.back = null;
    }
    
    public void invert(){
        Node aux = head;
        Node p = null;
        while (aux !=  null){
          p = aux.back;
          aux.back = aux.next;
          aux.next = p;              
          aux = aux.back;
        }      

        if(p != null )
           head = p.back;
    }     
}
