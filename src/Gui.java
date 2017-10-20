import javax.swing.*;
import java.awt.*;

public class Gui {
    private Dimension frameDimention = new Dimension(800, 500);

    Gui() {
        JFrame frame = new JFrame();
        frame.setResizable(false);
        frame.setSize(frameDimention);
        frame.setTitle("Склад варенья");
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        TabsBox tabsBox = new TabsBox();
        tabsBox.addTabs(frame.getContentPane());
        frame.setVisible(true);
    }
}
