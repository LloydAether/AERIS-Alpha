package com.aeris.service;

import com.aeris.domain.Usuario;
import com.aeris.persistence.repository.AuthRepository;
import com.aeris.security.PasswordUtil;

public class AuthService {

    private final AuthRepository authRepository;

    public AuthService() {
        this.authRepository = new AuthRepository();
    }

    public Usuario login(String usuario, String contrasena) {
        if (usuario == null || usuario.isBlank()) {
            return null;
        }

        if (contrasena == null || contrasena.isBlank()) {
            return null;
        }

        Usuario usuarioEncontrado = authRepository.buscarPorUsuario(usuario);

        if (usuarioEncontrado == null) {
            return null;
        }

        if (!"ACTIVO".equals(usuarioEncontrado.getEstado())) {
            return null;
        }

        String contrasenaGuardada = authRepository.obtenerContrasena(usuario);

        if (contrasenaGuardada == null) {
            return null;
        }

        boolean contrasenaValida = PasswordUtil.verify(
                contrasena,
                contrasenaGuardada
        );

        return contrasenaValida ? usuarioEncontrado : null;
    }

    public boolean cambiarContrasena(
            Usuario usuario,
            String actual,
            String nueva,
            String confirmar) {

        if (usuario == null) {
            return false;
        }

        if (actual == null || actual.isBlank()) {
            return false;
        }

        if (nueva == null || nueva.isBlank()) {
            return false;
        }

        if (confirmar == null || confirmar.isBlank()) {
            return false;
        }

        if (nueva.length() < 6) {
            return false;
        }

        if (!nueva.equals(confirmar)) {
            return false;
        }

        String hashActual = authRepository.obtenerContrasena(usuario.getUsuario());

        if (!PasswordUtil.verify(actual, hashActual)) {
            return false;
        }

        String nuevaHash = PasswordUtil.hash(nueva);

        return authRepository.actualizarContrasena(
                usuario.getIdUsuario(),
                nuevaHash
        );
    }
}