import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class TabsBox {
    private final static String MENU = "Меню";
    private final static String COLLECTION = "Список варений";
    private JPanel tabPanel = new JPanel(new CardLayout());

    public void addTabs(Container pane){
        JPanel comboBoxPane = new JPanel();
        String tabs[] = {MENU, COLLECTION};
        JComboBox tabBox = new JComboBox(tabs);
        tabBox.setEditable(false);
        tabBox.addItemListener(new Listener());
        comboBoxPane.add(tabBox);

        tabPanel.add(MenuScene.addScene1(), MENU);
        tabPanel.add(CollectionScene.addScene2(), COLLECTION);

        pane.add(comboBoxPane, BorderLayout.NORTH);
        pane.add(tabPanel, BorderLayout.CENTER);
    }

    class Listener implements ItemListener {
        public void itemStateChanged(ItemEvent event){
            CardLayout cardLayout = (CardLayout)(tabPanel.getLayout());
            cardLayout.show(tabPanel, (String) event.getItem());
        }
    }
}