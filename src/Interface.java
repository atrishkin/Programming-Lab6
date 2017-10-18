import javax.swing.*;
import java.awt.*;

public class Interface {
    Interface(){
        JFrame frame = new JFrame();
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setSize(new Dimension(600, 400));
        frame.setTitle("Склад варенья");
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
    }
}
