package repeat_and_test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ReadFile {
    FileReader fileReader;
    public String readFile(String path){
        StringBuilder sb = new StringBuilder();
        try {
            fileReader = new FileReader(path);
            int i;
            while ((i = fileReader.read()) != -1){
                sb.append((char) i);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return sb.toString();
    }
}
