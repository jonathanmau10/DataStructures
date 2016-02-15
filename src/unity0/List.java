
package unity0;

/**
 *
 * @author jonathan goyes
 */
public class List {
    private int data[];
    private int top;
    
    public List(){
        data = new int[100];
        top = 0;
    }
    
    public void add(int d){ // add an element in the last position
        data[top] = d;
        top++;
    }
    
    public void add(int position, int d){ // add an element in any position
        int i;
        for(i = 0; i < top; i++){
            if(data[i] == data[position]){
                data[i] = d;
                top++;
                break;
                
            }
        }
        
        for(int j = i; j < top; j++){
            data[j] = data[j+1];
        }
    }
    
    public int remove(int d){ // remove any element into of the list
        int i;
        for(i = 0; i < top; i++){
            if(data[i] == d){
                top--;
                break;
                
            }
        }
        
        for(int j = i; j < top; j++){
            data[j] = data[j+1];
        }
        return data[top];
    }
    
    public void print(){
        for(int i = 0; i < top ; i++){
            System.out.print(" " + data[i]);
            
        }
    }
}
