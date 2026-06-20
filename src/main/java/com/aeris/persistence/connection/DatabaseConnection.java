package com.aeris.persistence.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private DatabaseConnection() {}

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(
                DatabaseConfig.getUrl(),
                DatabaseConfig.getUser(),
                DatabaseConfig.getPassword()
        );
    }

    public static boolean testConnection() {
        try (Connection connection = getConnection()) {
            return connection != null && !connection.isClosed();
        } catch (SQLException e) {
            System.err.println("Error de conexión: " + e.getMessage());
            return false;
        }
    }
}