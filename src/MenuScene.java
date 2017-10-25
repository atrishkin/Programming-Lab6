import javax.swing.*;
import java.awt.*;

public class MenuScene extends JPanel{
    MenuScene(){
        JTextArea text = new JTextArea("Добро пожаловать на склад варенья!\n\nЕсли вы хотите загрузить или сохранить свой склад, используйте настройки.\n\nЕсли вы хотите работать с загруженным или новым складом, то перейдите во вкладку \"Список варений\"");
        text.setEditable(false);
        add(text, BorderLayout.CENTER);
    }
}