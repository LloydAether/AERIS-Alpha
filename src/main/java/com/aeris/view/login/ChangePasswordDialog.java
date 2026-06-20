package com.aeris.view.login;

import com.aeris.core.SessionManager;
import com.aeris.service.AuthService;
import com.aeris.ui.button.AerisButton;
import com.aeris.ui.theme.AerisTheme;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;

public class ChangePasswordDialog extends JDialog {

    private JPasswordField txtActual;
    private JPasswordField txtNueva;
    private JPasswordField txtConfirmar;
    private final AuthService authService = new AuthService();

    public ChangePasswordDialog(Window parent) {
        super(parent, "Cambiar contraseña", ModalityType.APPLICATION_MODAL);
        initComponents();
    }

    private void initComponents() {
        setSize(420, 360);
        setLocationRelativeTo(getParent());
        setResizable(false);

        JPanel panel = new JPanel(new MigLayout(
                "wrap 1, insets 30",
                "[grow]",
                "[]20[]8[]16[]8[]16[]8[]24[]"
        ));
        panel.setBackground(Color.WHITE);

        JLabel title = new JLabel("Cambiar contraseña");
        title.setFont(new Font("Segoe UI", Font.BOLD, 24));
        title.setForeground(AerisTheme.TEXT);

        txtActual = new JPasswordField();
        txtNueva = new JPasswordField();
        txtConfirmar = new JPasswordField();

        AerisButton btnGuardar = new AerisButton("Guardar");
        btnGuardar.addActionListener(e -> guardar());

        JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.addActionListener(e -> dispose());

        JPanel actions = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        actions.setOpaque(false);
        actions.add(btnCancelar);
        actions.add(btnGuardar);

        panel.add(title, "growx");
        panel.add(new JLabel("Contraseña actual"), "growx");
        panel.add(txtActual, "growx, h 40!");
        panel.add(new JLabel("Nueva contraseña"), "growx");
        panel.add(txtNueva, "growx, h 40!");
        panel.add(new JLabel("Confirmar contraseña"), "growx");
        panel.add(txtConfirmar, "growx, h 40!");
        panel.add(actions, "growx");

        setContentPane(panel);
    }

    private void guardar() {
        String actual = new String(txtActual.getPassword());
        String nueva = new String(txtNueva.getPassword());
        String confirmar = new String(txtConfirmar.getPassword());

        boolean ok = authService.cambiarContrasena(
                SessionManager.getUsuarioActual(),
                actual,
                nueva,
                confirmar
        );

        if (!ok) {
            JOptionPane.showMessageDialog(
                    this,
                    "No se pudo cambiar la contraseña. Verifique los datos.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
            return;
        }

        JOptionPane.showMessageDialog(
                this,
                "Contraseña actualizada correctamente.",
                "Correcto",
                JOptionPane.INFORMATION_MESSAGE
        );

        dispose();
    }
}