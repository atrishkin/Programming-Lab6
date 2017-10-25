import javax.swing.*;
public class FileChooser extends JDialog{
    FileChooser(JFileChooser fileChooser, String name){
        JDialog chooseDialog = new JDialog();
        chooseDialog.setModal(true);
        chooseDialog.setTitle(name);
        chooseDialog.setSize(560, 300);
        chooseDialog.setResizable(false);
        chooseDialog.add(fileChooser);
        chooseDialog.setVisible(true);

    }
}