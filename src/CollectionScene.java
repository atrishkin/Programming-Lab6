import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class CollectionScene {
    private static JPanel Scene2 = new JPanel(new GridLayout(2, 1, 10,10));

    private static Storage storage = new Storage();
    private static String[] header = new String[] {"Номер","Название","Литраж","Год","Приоритет"};
    //TODO: tab2
    public static JPanel addScene2(){
        //
        storage.addJam(new Jam("Малина",2.5,2014,2));
        storage.addJam(new Jam("Морожка",1,2016,1));
        storage.addJam(new Jam("Черника",3,2014,2));
        storage.addJam(new Jam("Морожка",1,2015,1));
        //
        JTable collectionTable = new JTable(storage.getContent(), header);
        collectionTable.setVisible(true);

        Scene2.add(collectionTable);
        Scene2.add(new JPanel());
        return Scene2;
    }
}
