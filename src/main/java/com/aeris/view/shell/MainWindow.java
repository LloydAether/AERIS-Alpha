package com.aeris.view.shell;

import com.aeris.ui.theme.AerisTheme;
import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {

    private JPanel contentPanel;

    public MainWindow() {
        initWindow();
    }

    private void initWindow() {
        setTitle("AERIS Alpha");
        setSize(1100, 720);
        setMinimumSize(new Dimension(900, 600));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        contentPanel = new JPanel(new BorderLayout());
        contentPanel.setBackground(AerisTheme.BACKGROUND);

        setContentPane(contentPanel);
    }

    public void showScreen(JPanel panel) {
        contentPanel.removeAll();
        contentPanel.add(panel, BorderLayout.CENTER);
        contentPanel.revalidate();
        contentPanel.repaint();
    }
}