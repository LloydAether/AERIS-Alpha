package com.aeris.view.modules;

import com.aeris.ui.theme.AerisTheme;
import javax.swing.*;
import java.awt.*;

public class RecursosPanel extends JPanel {

    public RecursosPanel() {
        setLayout(new BorderLayout());
        setBackground(AerisTheme.BACKGROUND);

        JLabel titulo = new JLabel("Recursos", SwingConstants.CENTER);
        titulo.setFont(new Font("Segoe UI", Font.BOLD, 32));
        titulo.setForeground(AerisTheme.TEXT);

        add(titulo, BorderLayout.CENTER);
    }
}