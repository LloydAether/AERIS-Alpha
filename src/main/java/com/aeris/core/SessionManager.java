package com.aeris.core;

import com.aeris.domain.Usuario;

public class SessionManager {

    private static Usuario usuarioActual;

    private SessionManager() {
    }

    public static void iniciarSesion(Usuario usuario) {
        usuarioActual = usuario;
    }

    public static Usuario getUsuarioActual() {
        return usuarioActual;
    }

    public static boolean haySesionActiva() {
        return usuarioActual != null;
    }

    public static int getEmpresaId() {
        if (usuarioActual == null) {
            throw new IllegalStateException("No existe una sesión activa.");
        }
        return usuarioActual.getIdEmpresa();
    }

    public static boolean esAdministrador() {
        return usuarioActual != null
                && "ADMIN".equalsIgnoreCase(usuarioActual.getRol());
    }

    public static boolean esOperador() {
        return usuarioActual != null
                && "OPERADOR".equalsIgnoreCase(usuarioActual.getRol());
    }

    public static void cerrarSesion() {
        usuarioActual = null;
    }
}