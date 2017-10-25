import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SaveButton{
    JButton saveButton(){
        JButton saveButton = new JButton("Сохранить");
        saveButton.addActionListener(new Listener());
        return saveButton;
    }
    class Listener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event){
            new SaveThread().run();
        }
    }
}
