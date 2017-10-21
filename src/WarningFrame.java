import javax.swing.*;

public class WarningFrame extends JFrame {
    WarningFrame(String message){
        add(new JTextArea(message));
        setResizable(false);
        setSize(NewJamDialog.getInsertDimention());
        setVisible(true);
    }
}
