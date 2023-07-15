package com.eugene.feature.storage;

import com.eugene.feature.prefs.Prefs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Storage {

    private static final Storage INSTANCE = new Storage();
    private Connection connection;
    private Storage(){
        String connectionUrl = new Prefs().getString("dbUrl");
        try{
            connection = DriverManager.getConnection(connectionUrl);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    public static Storage getInstance(){
        return INSTANCE;
    }

    public Connection getConnection(){
        return connection;
    }

    public int executeUpdate(String sql){
        try(Statement statement = connection.createStatement()){
            return statement.executeUpdate(sql);

        }catch (SQLException e){
            e.printStackTrace();
            return -1;
        }

    }

    public void close(){
        try{
            connection.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
