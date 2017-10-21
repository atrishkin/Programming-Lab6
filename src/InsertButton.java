import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InsertButton{
    JButton insertButton(){
        JButton insertButton = new JButton("Добавить элемент");
        insertButton.addActionListener(new Listener());
        return insertButton;
    }
    class Listener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent event){
            new NewJamDialog();
            CollectionScene.updateTable();
        }
    }
}
