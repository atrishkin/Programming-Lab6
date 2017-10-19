import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class TabsBox implements ItemListener {
    private final static String MENU = "Меню";
    private final static String COLLECTION = "Список варений";
    private JPanel tabPanel = new JPanel(new CardLayout());

    public void addTabs(Container pane){
        JPanel comboBoxPane = new JPanel();
        String tabs[] = {MENU, COLLECTION};
        JComboBox tabBox = new JComboBox(tabs);
        tabBox.setEditable(false);
        tabBox.addItemListener(this);
        comboBoxPane.add(tabBox);

        //TODO: tab1
        //TODO: tab2
        tabPanel.add(MenuScene.addScene1(), MENU);
        tabPanel.add(CollectionScene.addScene2(), COLLECTION);

        pane.add(comboBoxPane, BorderLayout.NORTH);
        pane.add(tabPanel, BorderLayout.CENTER);
    }
    public void itemStateChanged(ItemEvent event){
        CardLayout cardLayout = (CardLayout)(tabPanel.getLayout());
        cardLayout.show(tabPanel, (String) event.getItem());
    }
}
