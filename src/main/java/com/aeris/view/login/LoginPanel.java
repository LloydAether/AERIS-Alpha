package com.aeris.view.login;

import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.KeyStroke;
import com.aeris.core.ScreenManager;
import com.aeris.core.SessionManager;
import com.aeris.domain.Usuario;
import com.aeris.service.AuthService;
import com.aeris.ui.button.AerisButton;
import com.aeris.ui.theme.AerisTheme;
import com.aeris.view.main.AppShell;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;

public class LoginPanel extends JPanel {

    private JTextField txtUsuario;
    private JPasswordField txtPassword;
    private final AuthService authService = new AuthService();

    public LoginPanel() {
        initComponents();
    }

    private void initComponents() {
        setBackground(AerisTheme.BACKGROUND);
        setLayout(new MigLayout("fill, insets 0", "[grow]", "[grow]"));

        JPanel card = new JPanel(new MigLayout(
                "wrap 1, align center, insets 40",
                "[360!]",
                "[]20[]10[]20[]10[]20[]30[]20[]"
        ));
        card.setBackground(Color.WHITE);

        JLabel logo = new JLabel("◌", SwingConstants.CENTER);
        logo.setFont(new Font("Segoe UI", Font.BOLD, 52));
        logo.setForeground(AerisTheme.PRIMARY);

        JLabel titulo = new JLabel("AERIS", SwingConstants.CENTER);
        titulo.setFont(new Font("Segoe UI", Font.BOLD, 36));
        titulo.setForeground(AerisTheme.TEXT);

        JLabel subtitulo = new JLabel("Sistema empresarial", SwingConstants.CENTER);
        subtitulo.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        subtitulo.setForeground(AerisTheme.TEXT_SECONDARY);

        txtUsuario = new JTextField();
        txtUsuario.setFont(new Font("Segoe UI", Font.PLAIN, 14));

        txtPassword = new JPasswordField();
        txtPassword.setFont(new Font("Segoe UI", Font.PLAIN, 14));

        AerisButton btnLogin = new AerisButton("Iniciar sesión");
        btnLogin.addActionListener(e -> iniciarSesion());
        
        getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
        .put(KeyStroke.getKeyStroke("ENTER"), "login");

        getActionMap().put("login", new AbstractAction() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                iniciarSesion();
            }
        });        

        JLabel footer = new JLabel("AERIS Alpha • © 2026", SwingConstants.CENTER);
        footer.setForeground(AerisTheme.TEXT_SECONDARY);

        card.add(logo, "growx");
        card.add(titulo, "growx");
        card.add(subtitulo, "growx");

        card.add(new JLabel("Usuario"), "growx");
        card.add(txtUsuario, "growx, h 42!");

        card.add(new JLabel("Contraseña"), "growx");
        card.add(txtPassword, "growx, h 42!");

        card.add(btnLogin, "growx, h 44!");
        card.add(footer, "growx");

        add(card, "align center");
    }

    private void iniciarSesion() {
        String usuario = txtUsuario.getText().trim();
        String contrasena = new String(txtPassword.getPassword());

        Usuario usuarioAutenticado = authService.login(usuario, contrasena);

        if (usuarioAutenticado == null) {
            JOptionPane.showMessageDialog(
                    this,
                    "Usuario o contraseña incorrectos.",
                    "Acceso denegado",
                    JOptionPane.ERROR_MESSAGE
            );
            return;
        }

        SessionManager.iniciarSesion(usuarioAutenticado);
        ScreenManager.show(new AppShell());
    }
}