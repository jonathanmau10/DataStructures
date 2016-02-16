/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unity1.simpleStructures;

/**
 *
 * @author Jonathan goyes
 */
public class Test {
    
    
    public static void testingList(){
        System.out.println("*********Testing List*********");
        List l = new List();
        l.add(55);
        l.add(15);
        l.add(20);
        l.add(40);
        System.out.println("Initial Values: ");
        l.print();
        
        int c = l.count();
        
        System.out.println("total Nodes in List:  " + c);
        l.printFirstElement();
        l.printLastElement();
        
    }
    
    public static void main (String [ ] args) {
        
        testingList();
        
    }
}
