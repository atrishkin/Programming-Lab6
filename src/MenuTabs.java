import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class MenuTabs extends JPanel{
    private final static String MENU = "Меню";
    private final static String COLLECTION = "Список варений";
    private static JPanel tabPanel = new JPanel(new CardLayout());
    MenuTabs(){
        JMenuBar menuBar = new JMenuBar();
        menuBar.add(createSettingMenu());
        menuBar.add(createViewBox());
        add(menuBar, BorderLayout.NORTH);
        add(tabPanel, BorderLayout.CENTER);
    }
    private JMenu createSettingMenu(){
        JMenu menu = new JMenu("Настройки");
        return menu;
    }
    private JComboBox createViewBox(){
        String tabs[] = {MENU, COLLECTION};
        JComboBox tabBox = new JComboBox(tabs);
        tabBox.setEditable(false);
        tabBox.addItemListener(new ChangePanelListener());
        tabPanel.add(new MenuScene(), MENU);
        tabPanel.add(new CollectionScene(), COLLECTION);
        return tabBox;
    }
    private class ChangePanelListener implements ItemListener {
        @Override
        public void itemStateChanged(ItemEvent event){
            CardLayout cardLayout = (CardLayout)(tabPanel.getLayout());
            cardLayout.show(tabPanel, (String) event.getItem());
        }
    }
}
