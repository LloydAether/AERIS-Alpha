package com.aeris.ui.statusbar;

import com.aeris.config.CompanyConfig;
import com.aeris.ui.theme.AerisTheme;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AerisStatusBar extends JPanel {

    private JLabel right;
    private final DateTimeFormatter formatter =
            DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    public AerisStatusBar() {
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(0, 32));
        setBackground(Color.WHITE);
        setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, AerisTheme.BORDER));

        JLabel left = new JLabel(" Usuario: Admin  |  Empresa: " + CompanyConfig.COMPANY_NAME);
        left.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        left.setForeground(AerisTheme.TEXT);

        right = new JLabel();
        right.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        right.setForeground(AerisTheme.TEXT);

        add(left, BorderLayout.WEST);
        add(right, BorderLayout.EAST);

        iniciarReloj();
    }

    private void iniciarReloj() {
        Timer timer = new Timer(1000, e -> actualizarHora());
        timer.start();
        actualizarHora();
    }

    private void actualizarHora() {
        String fechaHora = LocalDateTime.now().format(formatter);
        right.setText("BD: 🟢 Conectado  |  " + CompanyConfig.APP_VERSION + "  |  " + fechaHora + " ");
    }
}