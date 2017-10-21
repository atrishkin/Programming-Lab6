import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClearButton{
    JButton clearButton(){
        JButton clearButton = new JButton("Очистить коллекцию");
        clearButton.addActionListener(new Listener());
        return clearButton;
    }
    class Listener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event){
            CollectionScene.getStorage().clearStorage();
            CollectionScene.updateTable();
        }
    }
}
