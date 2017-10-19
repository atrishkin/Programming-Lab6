import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class TabsBox implements ItemListener {
    final static String MENU = "Меню";
    final static String COLLECTION = "Список варений";
    JPanel tabPanel = new JPanel(new CardLayout());

    public void addTabs(Container pane){
        JPanel comboBoxPane = new JPanel();
        String tabs[] = {MENU, COLLECTION};
        JComboBox tabBox = new JComboBox(tabs);
        tabBox.setEditable(false);
        //TODO: Обработка эвента - смена панели
        tabBox.addItemListener(this);
        comboBoxPane.add(tabBox);

        JPanel tab1 = new JPanel();
        //tab1
        tab1.add(new JTextArea("1"));
        JPanel tab2 = new JPanel();
        //tab2
        tab2.add(new JTextArea("2"));
        tabPanel.add(tab1, MENU);
        tabPanel.add(tab2, COLLECTION);

        pane.add(comboBoxPane, BorderLayout.NORTH);
        pane.add(tabPanel, BorderLayout.CENTER);
    }
    public void itemStateChanged(ItemEvent event){
        CardLayout cardLayout = (CardLayout)(tabPanel.getLayout());
        cardLayout.show(tabPanel, (String) event.getItem());
    }
}
