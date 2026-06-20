package com.aeris.view.modules;

import com.aeris.ui.theme.AerisTheme;
import javax.swing.*;
import java.awt.*;

public class PagosPanel extends JPanel {

    public PagosPanel() {
        setLayout(new BorderLayout());
        setBackground(AerisTheme.BACKGROUND);

        JLabel titulo = new JLabel("Pagos", SwingConstants.CENTER);
        titulo.setFont(new Font("Segoe UI", Font.BOLD, 32));
        titulo.setForeground(AerisTheme.TEXT);

        add(titulo, BorderLayout.CENTER);
    }
}