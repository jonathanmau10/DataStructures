
package unity2.doubleList;

/**
 *
 * @author jonathan
 */
public class Test {
    public static void main (String [] args){        
        testingList();
    }
    
    public static void testingList(){
        List l = new List();
        l.add(5);
        l.add(7);
        l.add(3);
        l.add(11);
        System.out.println("Values into of the list: ");
        l.print();
        System.out.println("values with reversPrint() method are: ");
        l.reversePrint();
        l.push(55);
        l.print();
        
    }
}
