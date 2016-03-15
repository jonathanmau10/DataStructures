
package unity2.doubleList;

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
}
