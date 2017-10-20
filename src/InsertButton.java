import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InsertButton extends JButton{
    JButton insertButton(String name){
        JButton insertButton = new JButton(name);
        insertButton.addActionListener(new Listener());
        return insertButton;
    }
    class Listener implements ActionListener{
        public void actionPerformed(ActionEvent event){
            Storage storage = CollectionScene.getStorage();
            //
            storage.addJam(3, new Jam("fff", 2, 1,1));
            //
            CollectionScene.setStorage(storage);
            CollectionScene.updateTable();
        }
    }
}
