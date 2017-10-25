import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

class LoadThread implements Runnable {
    @Override
    public void run() {
        loadFromFile(MenuTabs.getLoadFile().getName(), CollectionScene.getStorage());
        CollectionScene.updateTable();
    }
    private synchronized void loadFromFile(String file, Storage jamStorage) {
        try {
            String result;
            int begin, end;
            Scanner fileReader = new Scanner(Paths.get(file));
            Gson gson = new GsonBuilder().create();
            Jam loadingJam;
            while(fileReader.hasNext()){
                result = fileReader.nextLine();
                if (result.startsWith("[")){
                    begin = result.indexOf("[")+1;
                    if(result.endsWith("]")){
                        end = result.lastIndexOf("]")-1;
                    } else { end = result.lastIndexOf(","); }
                    result = result.substring(begin, end);
                } else {
                    if(result.endsWith("]")) {
                        begin = result.indexOf("{");
                        end = result.lastIndexOf("]");
                        result = result.substring(begin, end);
                    } else {
                        begin = result.indexOf("{");
                        end = result.lastIndexOf(",");
                        result = result.substring(begin, end);
                    }
                }
                loadingJam = gson.fromJson(result, Jam.class);
                jamStorage.addJam(loadingJam);
            }
            fileReader.close();
            new WarningFrame("Данные из файла "+file+" загружены");
        } catch (IllegalStateException e) {
            new WarningFrame("Неправильный формат JSON в файле "+file);
        } catch (IOException e) {
            new WarningFrame("Файл "+file +" не найден!");
        }
    }
}