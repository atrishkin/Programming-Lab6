import sun.swing.table.DefaultTableCellHeaderRenderer;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
public class CollectionScene {
    private static JPanel Scene2 = new JPanel(new GridBagLayout());
    private static Storage storage = new Storage();
    private static JScrollPane scrollTable = new JScrollPane();
    private static JTable collectionTable = new JTable();
    private static DefaultTableModel model = new DefaultTableModel();

    public static JPanel addScene2(){
        //TODO: запись из файла, может в сцене 1
        //Probe content!!!
        for (int i = 0; i < 7; i++) {
            storage.addJam(new Jam("Малина",2.5,2014,2));
            storage.addJam(new Jam("Морошка",1,2016,1));
            storage.addJam(new Jam("Черника",3,2014,2));
            storage.addJam(new Jam("Морожка",1,2015,1));
        }
        //
        scrollTable = new JScrollPane(getCollectionTable());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridy = 1;
        Scene2.add(scrollTable, c);
        c.gridy = 2;
        Scene2.add(collectionButtons(), c);
        return Scene2;
    }
    public static void updateTable(){
            DefaultTableModel tableModel = (DefaultTableModel) collectionTable.getModel();
            tableModel.setRowCount(0);
            tableModel = storage.getModel();
            collectionTable.setModel(tableModel);
            tableModel.fireTableDataChanged();
    }
    private static JTable getCollectionTable(){
        model = storage.getModel();
        collectionTable = new JTable(model);
        JTableHeader header = collectionTable.getTableHeader();
        header.setDefaultRenderer(new DefaultTableCellHeaderRenderer());
        collectionTable.setEnabled(false);
        return collectionTable;
    }
    private static JPanel collectionButtons(){
        JPanel collectionButtons = new JPanel();
        collectionButtons.add(new InsertButton().insertButton("Добавить элемент"));
        collectionButtons.add(new SortButton().sortButton("Отсортировать по приоритету"));
        collectionButtons.add(new ClearButton().clearButton("Очистить коллекцию"));
        collectionButtons.add(new SaveButton().SaveButton("Сохранить"));
        return collectionButtons;
    }

    public static Storage getStorage() {
        return storage;
    }
    public static void setStorage(Storage storage) {
        CollectionScene.storage = storage;
    }
}
