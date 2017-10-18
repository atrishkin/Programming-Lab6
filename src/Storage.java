import java.util.Collections;
import java.util.Stack;

public class Storage {
    private int max = -1;
    private Stack<Jam> jamStorage = new Stack<Jam>();
    Storage(){
        jamStorage = new Stack<Jam>();
    }
    void sortStorage(){
        Collections.sort(jamStorage);
    }
    void findMax() {
        for (int i = 0; i < jamStorage.size(); i++) {
            if(jamStorage.get(i).getPriority() > max)
                max = jamStorage.get(i).getPriority();
        }
    }
    void addJam(int index, Jam j){
        jamStorage.add(index, j);
    }
    void addJam(Jam j){
        jamStorage.push(j);
    }
    void clearStorage(){
        max = -1;
        jamStorage = new Stack<Jam>();
    }
    Stack<Jam> getJam(){
        return jamStorage;
    }
    int getMax(){
        findMax();
        return max;}
}