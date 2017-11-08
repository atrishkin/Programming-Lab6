import javax.swing.*;
import java.awt.event.*;

public class FilterButton {
    JTextField filter;

    JTextField filterButton() {
        filter = new JTextField("Фильтровать");
        filter.addActionListener(new Listener());
        return filter;
    }

    class Listener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            try {
                int i = Integer.parseInt(filter.getText());
                CollectionScene.getStorage().filter(i);
                CollectionScene.updateTable();
            } catch (NumberFormatException e) {
                new WarningFrame("Введите число!");
            }
        }
    }
}
