import javax.swing.*;
import javax.swing.event.MenuDragMouseEvent;
import javax.swing.event.MenuDragMouseListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;

public class MenuTabs extends JPanel{
    private final static String MENU = "Меню";
    private final static String COLLECTION = "Список варений";
    private static JPanel tabPanel = new JPanel(new CardLayout());
    private static File loadFile = new File("");
    private static File saveFile = new File("");

    MenuTabs(){
        JMenuBar menuBar = new JMenuBar();
        menuBar.add(createSettingMenu());
        menuBar.add(createViewBox());
        add(menuBar, BorderLayout.NORTH);
        add(tabPanel, BorderLayout.CENTER);
    }
    private JMenu createSettingMenu(){
        JMenu menu = new JMenu("Настройки");
        JMenuItem load = new JMenuItem("Загрузить");
        JMenuItem save = new JMenuItem("Сохранить");
        load.addActionListener(new LoadListener());
        save.addActionListener(new SaveListener());
        menu.add(load);
        menu.add(save);
        return menu;
    }
    private class LoadListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
            fileChooser.setSize(560, 300);
            fileChooser.setVisible(true);
            int result = fileChooser.showDialog(null, "Load");
            switch (result) {
                case JFileChooser.APPROVE_OPTION:
                    loadFile = fileChooser.getSelectedFile();
                    break;
                case JFileChooser.CANCEL_OPTION: break;
                case JFileChooser.ERROR_OPTION: break;
            }
        }
    }
    private class SaveListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            try {
            } catch (IllegalArgumentException e) {
            }
        }
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