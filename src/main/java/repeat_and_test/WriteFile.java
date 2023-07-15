package repeat_and_test;

import java.io.FileWriter;
import java.io.IOException;

public class WriteFile {
    private FileWriter fileWriter;
    public boolean writeInFile(String path, String toWrite){
        try {
            fileWriter = new FileWriter(path);
            fileWriter.write(toWrite);
            fileWriter.close();
            return true;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
