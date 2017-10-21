import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.Collections;

public class Storage {
    private ArrayList<Jam> jamStorage = new ArrayList<>();
    private static String[] colNames = {"Номер","Название","Литраж","Год","Приоритет"};
    private static int compareCount = 1;
    Storage(){
        jamStorage = new ArrayList<>();
    }

    public static int getCompareCount() {
        return compareCount;
    }
    void sortStorage(){
        Collections.sort(jamStorage);
        if(compareCount > 0) compareCount -= 2; else compareCount += 2;
    }
    void addJam(int index, Jam j){
        jamStorage.add(index, j);
    }
    void addJam(Jam j){
        jamStorage.add(j);
    }
    void clearStorage(){
        jamStorage = new ArrayList<>();
    }
    ArrayList<Jam> getJam(){
        return jamStorage;
    }
    DefaultTableModel getModel(){
        Object[][] content = new Object[jamStorage.size()+1][5];
        for (int i = 0; i < jamStorage.size(); i++) {
            content[i][0] = i+1;
            content[i][1] = jamStorage.get(i).getName();
            content[i][2] = jamStorage.get(i).getSize();
            content[i][3] = jamStorage.get(i).getYear();
            content[i][4] = jamStorage.get(i).getPriority();
        }
        DefaultTableModel model = new DefaultTableModel(content, colNames);
        return model;
    }
}