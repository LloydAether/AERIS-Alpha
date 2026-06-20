package com.aeris.security;

import org.mindrot.jbcrypt.BCrypt;

public class PasswordUtil {

    private PasswordUtil() {}

    public static String hash(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    public static boolean verify(String password, String hashedPassword) {
        if (hashedPassword == null) return false;

        if (hashedPassword.startsWith("$2a$") || hashedPassword.startsWith("$2b$")) {
            return BCrypt.checkpw(password, hashedPassword);
        }

        // Temporal para usuarios antiguos con contraseña simple
        return password.equals(hashedPassword);
    }
}