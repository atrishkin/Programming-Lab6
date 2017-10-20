import sun.swing.table.DefaultTableCellHeaderRenderer;
import javax.swing.*;
import javax.swing.table.JTableHeader;
import java.awt.*;
public class CollectionScene {
    private static JPanel Scene2 = new JPanel(new GridBagLayout());
    private static String[] colNames = {"Номер","Название","Литраж","Год","Приоритет"};
    private static Storage storage = new Storage();

    //TODO: tab2
    public static JPanel addScene2(){
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridy = 1;
        Scene2.add(new JScrollPane(getCollectionTable()), c);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridy = 2;
        Scene2.add(getCollectionButtons(), c);
        return Scene2;
    }
    private static JTable getCollectionTable(){
        //TODO: запись из файла, может в сцене 1
        //Probe content!!!
        for (int i = 0; i < 7; i++) {
            storage.addJam(new Jam("Малина",2.5,2014,2));
            storage.addJam(new Jam("Морошка",1,2016,1));
            storage.addJam(new Jam("Черника",3,2014,2));
            storage.addJam(new Jam("Морожка",1,2015,1));
        }
        //
        JTable collectionTable = new JTable(storage.getContent(), colNames);
        JTableHeader header = collectionTable.getTableHeader();
        header.setDefaultRenderer(new DefaultTableCellHeaderRenderer());
        collectionTable.setEnabled(false);
        return collectionTable;
    }
    private static JPanel getCollectionButtons(){
        JPanel collectionButtons = new JPanel();
        collectionButtons.add(new InsertButton().insertButton("Добавить элемент"));
        collectionButtons.add(new SortButton().sortButton("Отсортировать по приоритету"));
        collectionButtons.add(new ClearButton().clearButton("Очистить коллекцию"));
        collectionButtons.add(new SaveButton().SaveButton("Сохранить"));
        //collectionButtons.set;
        return collectionButtons;
    }
}
