import javax.swing.*;
import java.awt.*;

public class CollectionScene {
    private static JPanel Scene2 = new JPanel(new GridLayout());
    public static JPanel addScene2(){
        Scene2.add(new JTextArea("2"));
        return Scene2;
    }
}
