package com.examenjava.common.config;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConfig {

        private static final String URL = "jdbc:mysql://localhost:3306/sgpzf";
        private static final String USER = "root";
        private static final String PASSWORD = "1098792956";
    
        public static Connection getConnection() throws SQLException {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        }
    
}
