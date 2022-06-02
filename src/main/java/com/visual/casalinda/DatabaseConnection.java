package com.visual.casalinda;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    public static Connection getConnection(){
        Connection connection = null;
        try {
            String url = "jdbc:mysql://localhost:3306/CasaLinda?user=root&password=Oklkd4##";
            connection = DriverManager.getConnection(url);
            System.out.println("connect");
        } catch (SQLException e) {
            System.out.println("fds");
            e.printStackTrace();
        }
        return connection;
    }
}
