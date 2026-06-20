package com.aeris.persistence.repository;

import com.aeris.domain.Usuario;
import com.aeris.persistence.connection.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AuthRepository {

    public Usuario buscarPorUsuario(String usuario) {
        String sql = """
            SELECT id_usuario, id_empresa, nombres, usuario, rol::text, estado::text
            FROM aeris.usuario
            WHERE usuario = ?
            LIMIT 1
        """;

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, usuario);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Usuario(
                            rs.getInt("id_usuario"),
                            rs.getInt("id_empresa"),
                            rs.getString("nombres"),
                            rs.getString("usuario"),
                            rs.getString("rol"),
                            rs.getString("estado")
                    );
                }
            }

        } catch (SQLException e) {
            System.err.println("Error buscando usuario: " + e.getMessage());
        }

        return null;
    }

    public String obtenerContrasena(String usuario) {
        String sql = """
            SELECT contrasena
            FROM aeris.usuario
            WHERE usuario = ?
            LIMIT 1
        """;

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, usuario);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getString("contrasena");
                }
            }

        } catch (SQLException e) {
            System.err.println("Error obteniendo contraseña: " + e.getMessage());
        }

        return null;
    }

    public boolean actualizarContrasena(int idUsuario, String nuevaContrasena) {
        String sql = """
            UPDATE aeris.usuario
            SET contrasena = ?
            WHERE id_usuario = ?
        """;

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, nuevaContrasena);
            stmt.setInt(2, idUsuario);

            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            System.err.println("Error actualizando contraseña: " + e.getMessage());
        }

        return false;
    }
}