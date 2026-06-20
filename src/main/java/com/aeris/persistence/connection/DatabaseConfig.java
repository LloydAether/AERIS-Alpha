package com.aeris.persistence.connection;

import java.io.InputStream;
import java.util.Properties;

public class DatabaseConfig {

    private static final Properties properties = new Properties();

    static {
        try (InputStream input = DatabaseConfig.class
                .getClassLoader()
                .getResourceAsStream("database.properties")) {

            if (input == null) {
                throw new RuntimeException("No se encontró database.properties");
            }

            properties.load(input);

        } catch (Exception e) {
            throw new RuntimeException("Error cargando configuración de base de datos", e);
        }
    }

    public static String getUrl() {
        return "jdbc:postgresql://"
                + properties.getProperty("db.host")
                + ":"
                + properties.getProperty("db.port")
                + "/"
                + properties.getProperty("db.database")
                + "?sslmode=require";
    }

    public static String getUser() {
        return properties.getProperty("db.user");
    }

    public static String getPassword() {
        return properties.getProperty("db.password");
    }
}