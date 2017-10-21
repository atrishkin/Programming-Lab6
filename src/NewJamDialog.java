import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewJamDialog extends JDialog{
    private static Dimension insertDimention = new Dimension(800, 180);
    private JTextArea speech = new JTextArea("Введите параметры банки с вареньем. Пожалуйста, следуйте инструкциям и вводите реальные \nданные, в указанном формате. Будьте внимательнее! Спасибо");
    private JTextArea indexText = new JTextArea("Индекс (от 1 до "+CollectionScene.getStorage().getJam().size()+"):");
    private JTextArea nameText = new JTextArea("Название варенья:");
    private JTextArea sizeText = new JTextArea("Литраж:");
    private JTextArea yearText = new JTextArea("Год приготовления:");
    private JTextArea priorityText = new JTextArea("Приоритет (целое число):");

    public static Dimension getInsertDimention() {
        return insertDimention;
    }
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
        JTextField index = new JTextField();
        index.addActionListener(new IndexListener());
        JTextField name = new JTextField();
        name.addActionListener(new NameListener());
        JTextField size = new JTextField();
        size.addActionListener(new SizeListener());
        JTextField year = new JTextField();
        year.addActionListener(new YearListener());
        JTextField priority = new JTextField();
        priority.addActionListener(new PriorityListener());
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
        c.gridy=3;
        c.gridx=2;
        JButton enterButton = new JButton("Ввод");
        enterButton.addActionListener(new EnterListener());
        add(enterButton, c);
        c.gridy=0;
        c.gridx=0;
        c.gridwidth=5;
        speech.setLineWrap(true);
        add(speech, c);
        setVisible(true);
    }
    class EnterListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent event){

        }
    }
    class IndexListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent event){

        }
    }
    class NameListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent actionEvent) {

        }
    }
    class SizeListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent actionEvent) {

        }
    }
    class YearListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent actionEvent) {

        }
    }
    class PriorityListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent actionEvent) {

        }
    }
}
