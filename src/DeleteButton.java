import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteButton {
    JTextField deleteIndex;

    JTextField deleteButton() {
        deleteIndex = new JTextField("Удалить");
        deleteIndex.addActionListener(new Listener());
        return deleteIndex;
    }

    class Listener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            try {
                int i = Integer.parseInt(deleteIndex.getText());
                CollectionScene.getStorage().delete(i-1);
                CollectionScene.updateTable();
            } catch (NumberFormatException e) {
                new WarningFrame("Введите число!");
            }
        }
    }
}
