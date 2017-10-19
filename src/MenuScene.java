import javax.swing.*;
import java.awt.*;

public class MenuScene {
    private static JPanel Scene1 = new JPanel(new BorderLayout());
    //TODO: tab1
    public static JPanel addScene1(){
        Scene1.add(new JTextArea("1"));
        return Scene1;
    }
}
