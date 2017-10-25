import sun.swing.table.DefaultTableCellHeaderRenderer;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CollectionScene extends JPanel {
    private static Storage storage = new Storage();
    private static JTable collectionTable = new JTable();
    private static DefaultTableModel model = new DefaultTableModel();

    CollectionScene(){
        //TODO: запись из файла, может в сцене 1
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridy = 1;
        add(new JScrollPane(getCollectionTable()), c);
        c.gridy = 2;
        add(collectionButtons(), c);
    }
    static void updateTable(){
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
        collectionButtons.add(new InsertButton().insertButton());
        collectionButtons.add(generateButton());
        collectionButtons.add(new SortButton().sortButton());
        collectionButtons.add(new ClearButton().clearButton());
        //
        return collectionButtons;
    }
    private static JButton generateButton(){
        class genListener implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent event) {
                for (int i = 0; i < 7; i++) {
                    storage.addJam(new Jam("Малина",2.5,2014,2));
                    storage.addJam(new Jam("Морошка",1,2016,1));
                    storage.addJam(new Jam("Черника",3,2014,2));
                    storage.addJam(new Jam("Морожка",1,2015,1));
                }
                CollectionScene.updateTable();
            }
        }
        JButton gen = new JButton("Сгенерировать");
        gen.addActionListener(new genListener());
        return gen;
    }
    static Storage getStorage() {
        return storage;
    }
}
