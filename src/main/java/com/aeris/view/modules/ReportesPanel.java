package com.aeris.view.modules;

import com.aeris.ui.theme.AerisTheme;
import javax.swing.*;
import java.awt.*;

public class ReportesPanel extends JPanel {

    public ReportesPanel() {
        setLayout(new BorderLayout());
        setBackground(AerisTheme.BACKGROUND);

        JLabel titulo = new JLabel("Reportes", SwingConstants.CENTER);
        titulo.setFont(new Font("Segoe UI", Font.BOLD, 32));
        titulo.setForeground(AerisTheme.TEXT);

        add(titulo, BorderLayout.CENTER);
    }
}