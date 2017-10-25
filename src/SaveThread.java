import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

class SaveThread implements Runnable{
    @Override
    public void run() {
        writeToFile(MenuTabs.getSaveFile().getName(), CollectionScene.getStorage());
    }
    private synchronized void writeToFile (String file, Storage jamStorage) {
        try {
            BufferedWriter fileWriter = new BufferedWriter(new FileWriter(file));
            Gson gson = new GsonBuilder().create();
            fileWriter.write("[");
            for (int i = 0; i < jamStorage.getJam().size(); i++) {
                fileWriter.write(gson.toJson(jamStorage.getJam().get(i)));
                if(i < jamStorage.getJam().size()-1) {
                    fileWriter.write(",");
                    fileWriter.newLine();
                } else { fileWriter.write("]"); }
            }
            fileWriter.close();
            new WarningFrame("Сохранение в файл "+file+" успешно");
        } catch (IOException e) {
            new WarningFrame("Не найден файл для сохранения, выберете файл через настройки");
        }
    }
}