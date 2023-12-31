package com.eugene.feature.prefs;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;


import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class Prefs {
    public static final String DEFAULT_PREFS_FILENAME = "prefs.json";
    private Map<String, Object> prefs = new HashMap<>();

    public Prefs (){
        this(DEFAULT_PREFS_FILENAME);
    }
    public Prefs(String fileName){
        try {
            //String json = String.join("\n", Files.readAllLines(Paths.get(fileName)));
            String json = Files.readString(Paths.get(fileName));
            Type type = TypeToken.getParameterized(Map.class, String.class, Object.class).getType();
            prefs = new Gson().fromJson(json, type);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getString(String key){
        return getPref(key).toString();
    }

    public Object getPref(String key){
        return prefs.get(key);
    }
    

}
