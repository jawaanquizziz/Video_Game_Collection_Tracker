package com.gametracker.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseUtil {

    // ---!!! IMPORTANT !!!---
    // --- EDIT THESE VALUES ---
    private static final String DB_URL = "jdbc:mysql://localhost:3306/game_tracker_db";
    private static final String DB_USER = "root"; // Your MySQL username
    private static final String DB_PASSWORD = "jawaan2720"; // Your MySQL password
    // -------------------------

    // Static block to load the MySQL driver
    static {
        try {
            // This explicitly loads the driver.
            // Modern JDBC drivers often auto-register, but this is safer.
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.err.println("Failed to load MySQL JDBC driver.");
            e.printStackTrace();
            throw new RuntimeException("MySQL JDBC driver not found.", e);
        }
    }

    /**
     * Gets a connection to the database.
     *
     * @return A Connection object
     * @throws SQLException if a database access error occurs
     */
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
    }
    
    /**
     * Helper method to test the connection.
     */
    public static void testConnection() {
        try (Connection conn = getConnection()) {
            if (conn != null) {
                System.out.println("Database connection successful!");
            } else {
                System.err.println("Failed to make database connection.");
            }
        } catch (SQLException e) {
            System.err.println("Database connection failed!");
            e.printStackTrace();
        }
    }
}
