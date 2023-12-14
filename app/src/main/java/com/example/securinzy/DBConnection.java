package com.example.securinzy;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    //Christine's URL
    private static final String DB_URL = "jdbc:ucanaccess://C:\\Users\\kokig\\OneDrive\\Desktop\\DBSecurinzyyyy.accdb";
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL);
    }
}
