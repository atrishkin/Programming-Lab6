import javax.swing.*;
import java.awt.*;

public class WarningFrame extends JDialog {
    WarningFrame(String message){
        setModal(true);
        setLayout(new BorderLayout());
        add(new JTextArea(message));
        setResizable(false);
        setSize(NewJamDialog.getInsertDimention());
        setVisible(true);
    }
}
