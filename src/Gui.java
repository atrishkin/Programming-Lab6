import javax.swing.*;
import java.awt.*;

public class Gui extends JFrame{
    private Dimension frameDimention = new Dimension(900, 500);

    Gui() {
        //TODO: В центре окна
        setResizable(false);
        setSize(frameDimention);
        setTitle("Склад варенья");
        setDefaultCloseOperation(this.EXIT_ON_CLOSE);
//        TabsBox tabsBox = new TabsBox();
//        tabsBox.addTabs(frame.getContentPane());
        add(new MenuTabs());
        setVisible(true);
    }
}
