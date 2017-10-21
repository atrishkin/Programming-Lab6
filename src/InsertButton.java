import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InsertButton{
    JButton insertButton(String name){
        JButton insertButton = new JButton(name);
        insertButton.addActionListener(new Listener());
        return insertButton;
    }
    class Listener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent event){
            Storage storage = CollectionScene.getStorage();
            //
            //TODO: Добавление на элемент ниже, ограничение с 1 до size
            new NewJamDialog();

            //
            CollectionScene.setStorage(storage);
            CollectionScene.updateTable();
        }
    }
}
