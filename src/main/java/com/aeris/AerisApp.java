package com.aeris;

import com.aeris.core.ScreenManager;
import com.aeris.view.shell.MainWindow;
import com.aeris.view.splash.SplashPanel;
import com.formdev.flatlaf.FlatLightLaf;

import javax.swing.*;

public class AerisApp {

    public static void main(String[] args) {
        configurarTema();

        SwingUtilities.invokeLater(() -> {
            MainWindow window = new MainWindow();
            ScreenManager.init(window);
            ScreenManager.show(new SplashPanel());
            window.setVisible(true);
        });
    }

    private static void configurarTema() {
        try {
            UIManager.setLookAndFeel(new FlatLightLaf());
            UIManager.put("Component.arc", 16);
            UIManager.put("Button.arc", 16);
            UIManager.put("TextComponent.arc", 14);
        } catch (Exception e) {
            System.err.println("No se pudo cargar el tema visual.");
        }
    }
}