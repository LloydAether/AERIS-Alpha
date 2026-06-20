package com.aeris.ui.header;

import com.aeris.core.ScreenManager;
import com.aeris.core.SessionManager;
import com.aeris.domain.Usuario;
import com.aeris.ui.theme.AerisTheme;
import com.aeris.view.login.ChangePasswordDialog;
import com.aeris.view.login.LoginPanel;

import javax.swing.*;
import java.awt.*;

public class AerisHeader extends JPanel {

    private JLabel breadcrumb;

    public AerisHeader() {

        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(0, 70));
        setBackground(Color.WHITE);
        setBorder(BorderFactory.createEmptyBorder(0,24,0,24));

        breadcrumb = new JLabel("Dashboard");
        breadcrumb.setFont(new Font("Segoe UI", Font.BOLD, 15));
        breadcrumb.setForeground(AerisTheme.TEXT);

        JTextField search = new JTextField("Buscar...");
        search.setPreferredSize(new Dimension(320,38));

        JButton nuevo = new JButton("+ Nuevo");
        nuevo.setBackground(AerisTheme.PRIMARY);
        nuevo.setForeground(Color.WHITE);
        nuevo.setFocusPainted(false);

        JButton userButton = new JButton(obtenerNombreUsuario() + " ▼");
        userButton.setBorderPainted(false);
        userButton.setFocusPainted(false);
        userButton.setBackground(Color.WHITE);
        userButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

        JPopupMenu popup = new JPopupMenu();

        JMenuItem perfil = new JMenuItem("Mi perfil");
        perfil.setEnabled(false);

        JMenuItem cambiarPassword = new JMenuItem("Cambiar contraseña");
        cambiarPassword.addActionListener(e -> abrirCambioPassword());

        JMenuItem cerrar = new JMenuItem("Cerrar sesión");
        cerrar.addActionListener(e -> cerrarSesion());

        popup.add(perfil);
        popup.add(cambiarPassword);
        popup.addSeparator();
        popup.add(cerrar);

        userButton.addActionListener(e ->
                popup.show(userButton,0,userButton.getHeight()));

        JPanel right = new JPanel(new FlowLayout(FlowLayout.RIGHT,12,16));
        right.setOpaque(false);

        right.add(search);
        right.add(nuevo);
        right.add(userButton);

        add(breadcrumb,BorderLayout.WEST);
        add(right,BorderLayout.EAST);

    }

    public void setBreadcrumb(String text){
        breadcrumb.setText(text);
    }

    private String obtenerNombreUsuario(){

        Usuario usuario = SessionManager.getUsuarioActual();

        if(usuario==null){
            return "Usuario";
        }

        return usuario.getNombres();

    }

    private void abrirCambioPassword(){

        Window window = SwingUtilities.getWindowAncestor(this);

        ChangePasswordDialog dialog =
                new ChangePasswordDialog(window);

        dialog.setVisible(true);

    }

    private void cerrarSesion(){

        int opcion = JOptionPane.showConfirmDialog(
                this,
                "¿Desea cerrar sesión?",
                "Cerrar sesión",
                JOptionPane.YES_NO_OPTION);

        if(opcion==JOptionPane.YES_OPTION){

            SessionManager.cerrarSesion();

            ScreenManager.show(new LoginPanel());

        }

    }

}