import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class Storage {
    private int max = -1;
    private ArrayList<Jam> jamStorage = new ArrayList<>();
    Storage(){
        jamStorage = new ArrayList<>();
    }
    void sortStorage(){
        Collections.sort(jamStorage);
    }
    private void findMax() {
        for (int i = 0; i < jamStorage.size(); i++) {
            if(jamStorage.get(i).getPriority() > max)
                max = jamStorage.get(i).getPriority();
        }
    }
    void addJam(int index, Jam j){
        jamStorage.add(index, j);
    }
    void addJam(Jam j){
        jamStorage.add(j);
    }
    void clearStorage(){
        max = -1;
        jamStorage = new ArrayList<>();
    }
    ArrayList<Jam> getJam(){
        return jamStorage;
    }
    Object[][] getContent(){
        Object[][] content = new Object[jamStorage.size()][5];
        for (int i = 0; i < jamStorage.size(); i++) {
            content[i][0] = i;
            content[i][1] = jamStorage.get(i).getName();
            content[i][2] = jamStorage.get(i).getSize();
            content[i][3] = jamStorage.get(i).getYear();
            content[i][4] = jamStorage.get(i).getPriority();
        }
        return content;
    }
    int getMax(){
        findMax();
        return max;}
}