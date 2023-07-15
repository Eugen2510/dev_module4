package repeat_and_test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main (String [] args){
        DTO user1 = new DTO("Ivan", 25);
        DTO user2 = new DTO("Petro", 35);

        Map<String, DTO> map = new HashMap<>();
        map.put("user1", user1);
        map.put("user2", user2);


        List<DTO> users = new ArrayList<>();
        users.add(user1);
        users.add(user2);
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        String toWrite = gson.toJson(map);

        boolean b = new WriteFile().writeInFile("./src/main/java/source/MyFile.txt", toWrite);
        System.out.println(b);

        String fromFile = new ReadFile().readFile("./src/main/java/source/MyFile.txt");
        System.out.println(fromFile);

        Type type = TypeToken.getParameterized(Map.class, String.class, DTO.class).getType();
        map = gson.fromJson(fromFile, type);
        System.out.println(map);
    }
}
