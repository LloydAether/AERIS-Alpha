package com.aeris.core;

import com.aeris.view.shell.MainWindow;
import javax.swing.JPanel;

public class ScreenManager {

    private static MainWindow mainWindow;

    private ScreenManager() {}

    public static void init(MainWindow window) {
        mainWindow = window;
    }

    public static void show(JPanel panel) {
        if (mainWindow == null) {
            throw new IllegalStateException("MainWindow no ha sido inicializado.");
        }
        mainWindow.showScreen(panel);
    }
}