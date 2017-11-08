import javax.swing.*;
import java.awt.*;

public class Gui extends JFrame{
    private Dimension frameDimention = new Dimension(950, 500);
    Gui() {
        setResizable(false);
        setSize(frameDimention);
        setTitle("Склад варенья");
        setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        add(new MenuTabs());
        setVisible(true);
    }
}
