
package unity1;

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
}
