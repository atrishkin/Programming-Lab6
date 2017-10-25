import javax.swing.*;
import java.awt.*;

public class Gui extends JFrame{
    private Dimension frameDimention = new Dimension(1000, 600);

    Gui() {
        //TODO: В центре окна
        setResizable(false);
        setSize(frameDimention);
        setTitle("Склад варенья");
        setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        add(new MenuTabs());
        setVisible(true);
    }
}
