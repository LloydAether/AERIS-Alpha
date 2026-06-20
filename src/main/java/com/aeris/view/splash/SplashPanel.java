package com.aeris.view.splash;

import com.aeris.core.ScreenManager;
import com.aeris.ui.theme.AerisTheme;
import com.aeris.view.login.LoginPanel;
import javax.swing.*;
import java.awt.*;

public class SplashPanel extends JPanel {

    public SplashPanel() {
        initComponents();
        cargarSistema();
    }

    private void initComponents() {
        setLayout(new BorderLayout());
        setBackground(AerisTheme.SIDEBAR);

        JLabel logo = new JLabel("◌", SwingConstants.CENTER);
        logo.setFont(new Font("Segoe UI", Font.BOLD, 64));
        logo.setForeground(AerisTheme.PRIMARY_HOVER);

        JLabel titulo = new JLabel("AERIS", SwingConstants.CENTER);
        titulo.setFont(new Font("Segoe UI", Font.BOLD, 48));
        titulo.setForeground(Color.WHITE);

        JLabel version = new JLabel("Alpha", SwingConstants.CENTER);
        version.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        version.setForeground(new Color(215, 215, 225));

        JLabel estado = new JLabel("Inicializando sistema...", SwingConstants.CENTER);
        estado.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        estado.setForeground(Color.WHITE);

        JProgressBar barra = new JProgressBar();
        barra.setIndeterminate(true);
        barra.setBorderPainted(false);

        JPanel centro = new JPanel(new GridLayout(3, 1, 0, 6));
        centro.setOpaque(false);
        centro.add(logo);
        centro.add(titulo);
        centro.add(version);

        add(estado, BorderLayout.NORTH);
        add(centro, BorderLayout.CENTER);
        add(barra, BorderLayout.SOUTH);
    }

    private void cargarSistema() {
        Timer timer = new Timer(2500, e -> {
            ScreenManager.show(new LoginPanel());
        });
        timer.setRepeats(false);
        timer.start();
    }
}