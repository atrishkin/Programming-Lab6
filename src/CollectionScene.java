import sun.swing.table.DefaultTableCellHeaderRenderer;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
public class CollectionScene {
    private static JPanel Scene2 = new JPanel(new GridLayout(2, 1, 10,10));
    private static String[] coloumNames = {"Номер","Название","Литраж","Год","Приоритет"};
    private static Storage storage = new Storage();

    //TODO: tab2
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
        JTable collectionTable = new JTable(storage.getContent(), coloumNames);
        JTableHeader header = collectionTable.getTableHeader();
        header.setDefaultRenderer(new DefaultTableCellHeaderRenderer());
        collectionTable.setEnabled(false);

        Scene2.add(new JScrollPane(collectionTable));
        Scene2.add(new JPanel());
        return Scene2;
    }
}
