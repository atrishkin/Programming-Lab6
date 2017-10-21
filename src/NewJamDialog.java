import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewJamDialog extends JDialog{
    private static Dimension insertDimention = new Dimension(900, 180);
    private JTextArea speech = new JTextArea("Введите параметры банки с вареньем. Пожалуйста, следуйте инструкциям и вводите реальные \nданные, в указанном формате. Будьте внимательнее! Спасибо");
    private JTextArea indexText = new JTextArea("Индекс (от 1 до "+(CollectionScene.getStorage().getJam().size()+1)+"):");
    private JTextArea nameText = new JTextArea("Название варенья:");
    private JTextArea sizeText = new JTextArea("Литраж:");
    private JTextArea yearText = new JTextArea("Год приготовления:");
    private JTextArea priorityText = new JTextArea("Приоритет (целое число):");
    //TODO: ограничить количество вводимых символов
    private JTextField index = new JTextField();
    private JTextField name = new JTextField();
    private JTextField size = new JTextField();
    private JTextField year = new JTextField();
    private JTextField priority = new JTextField();
    static Dimension getInsertDimention() {
        return insertDimention;
    }
    NewJamDialog(){
        setModal(true);
        setResizable(false);
        setSize(insertDimention);
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill= GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(10, 10, 10, 0);
        c.gridy=1;
        c.gridx=0;
        indexText.setEditable(false);
        nameText.setEditable(false);
        sizeText.setEditable(false);
        yearText.setEditable(false);
        priorityText.setEditable(false);
        speech.setEditable(false);
        add(indexText, c);
        c.gridx=1;
        nameText.setSize(1, 10);
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
            String massage = new String("");
            int ind =0;
            Jam jam = new Jam();
            try {
                ind = Integer.parseInt(index.getText());
                if(ind > CollectionScene.getStorage().getJam().size()+1 ||  0 >= ind){
                    massage += "\nПроверте данные в поле ИНДЕКС";
                }
            } catch(NumberFormatException e) {
                massage += "\nПроверте данные в поле ИНДЕКС, возможно они не целочисленные";
            }
            if(name.getText().equals("")) massage += "\nВведите название варенья";
            else jam.setName(name.getText());
            try {
                double i = Double.parseDouble(size.getText());
                if(0 >= i){
                    massage += "\nПроверте данные в поле ЛИТРАЖ";
                } else {
                    jam.setSize(i);
                }
            } catch(NumberFormatException e) {
                massage += "\nПроверте данные в поле ЛИТРАЖ, возможно они не числовые";
            }
            try {
                int i = Integer.parseInt(year.getText());
                if(0 >= i ){
                    massage += "\nПроверте данные в поле ГОД";
                } else {
                    jam.setYear(i);
                }
            } catch(NumberFormatException e) {
                massage += "\nПроверте данные в поле ГОД, возможно они не числовые";
            }
            try{
                int i = Integer.parseInt(priority.getText());
                jam.setPriority(i);
            } catch(NumberFormatException e){
                massage += "\nПроверте данные в поле ПРИОРИТЕТ, возможно они не числовые";
            }
            if(massage.equals("")){
                CollectionScene.getStorage().addJam(ind-1, jam);
                dispose();
            } else {
                new WarningFrame(massage);
            }
        }
    }
}
