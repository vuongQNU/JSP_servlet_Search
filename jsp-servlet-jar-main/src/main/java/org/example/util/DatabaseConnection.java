package org.example.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private final String jdbcURL = "jdbc:mysql://localhost:3306/jsp_serlet";
    private final String jdbcUsername = "root";
    private final String jdbcPassword = "19092004";

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);

    }
} 
