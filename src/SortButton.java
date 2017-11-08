import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SortButton{
    JButton sortButton(){
        JButton sortButton = new JButton("Отсортировать по приоритету");
        sortButton.addActionListener(new Listener());
        return sortButton;
    }
    class Listener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event){
            System.out.println(event);
            CollectionScene.getStorage().sortStorage();
            CollectionScene.updateTable();
        }
    }
}
