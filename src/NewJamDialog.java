import javax.swing.*;
import java.awt.*;

public class NewJamDialog extends JDialog{
    private Dimension insertDimention = new Dimension(800, 150);
    private JTextArea speech = new JTextArea("Введите параметры банки с вареньем. Пожалуйста, следуйте инструкциям и вводите реальные  данные, в указанном формате. Будьте внимательнее! Спасибо");
    private JTextArea indexText = new JTextArea("Индекс (от 1 до "+CollectionScene.getStorage().getJam().size()+"):");
    private JTextArea nameText = new JTextArea("Название варенья:");
    private JTextArea sizeText = new JTextArea("Литраж:");
    private JTextArea yearText = new JTextArea("Год приготовления:");
    private JTextArea priorityText = new JTextArea("Приоритет (целое число):");
    private JTextField index = new JTextField();
    private JTextField name = new JTextField();
    private JTextField size = new JTextField();
    private JTextField year = new JTextField();
    private JTextField priority = new JTextField();

    NewJamDialog(){
        setResizable(false);
        setSize(insertDimention);
        setTitle("Добавим варенье!");
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill= GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(10, 10, 10, 0);
        c.gridy=1;
        c.gridx=0;
        add(indexText, c);
        c.gridx=1;
        add(nameText, c);
        c.gridx=2;
        add(sizeText, c);
        c.gridx=3;
        add(yearText, c);
        c.gridx=4;
        add(priorityText, c);
        c.gridy=2;
        c.gridx=0;
        add(index, c);
        c.gridx=1;
        add(name, c);
        c.gridx=2;
        add(size, c);
        c.gridx=3;
        add(year, c);
        c.gridx=4;
        add(priority, c);
        c.gridy=0;
        c.gridx=0;
        c.gridwidth=5;
        speech.setLineWrap(true);
        add(speech, c);
        setVisible(true);
    }
}
