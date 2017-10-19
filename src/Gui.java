import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class Gui {
    Dimension frameDimention = new Dimension(800, 600);

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
