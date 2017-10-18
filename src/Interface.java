import javax.swing.*;
import java.awt.*;

public class Interface {
    Dimension frameDimention = new Dimension(800, 600);
    Interface(){
        JFrame frame = new JFrame();
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setSize(frameDimention);
        frame.setTitle("Склад варенья");
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        //frame.setLayout(new CardLayout());
    }
}
