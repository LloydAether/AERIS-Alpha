package com.aeris;

import com.aeris.persistence.connection.DatabaseConnection;

public class ConnectionTest {

    public static void main(String[] args) {
        if (DatabaseConnection.testConnection()) {
            System.out.println("✅ Conectado correctamente a Supabase");
        } else {
            System.out.println("❌ No se pudo conectar a Supabase");
        }
    }
}