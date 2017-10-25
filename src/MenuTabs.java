import javax.swing.*;
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
    public static File getLoadFile() {
        return loadFile;
    }
    public static File getSaveFile() {
        return saveFile;
    }
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
            fileChooser.setDialogTitle("Выберете загрузочный json файл");
            int result = fileChooser.showDialog(null, "Load");
                if( result == JFileChooser.APPROVE_OPTION) {
                    loadFile = fileChooser.getSelectedFile();
                    new LoadThread().run();
                }
        }
    }
    private class SaveListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
            fileChooser.setDialogTitle("Выберете файл сохранения");
            int result = fileChooser.showDialog(null, "Save");
            if( result == JFileChooser.APPROVE_OPTION) {
                saveFile = fileChooser.getSelectedFile();
                new SaveThread().run();
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
