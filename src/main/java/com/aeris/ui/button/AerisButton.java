package com.aeris.ui.button;

import com.aeris.ui.theme.AerisTheme;
import javax.swing.JButton;
import java.awt.Cursor;
import java.awt.Font;

public class AerisButton extends JButton {

    public AerisButton(String text) {
        super(text);
        setFont(new Font("Segoe UI", Font.BOLD, 14));
        setForeground(AerisTheme.TEXT_LIGHT);
        setBackground(AerisTheme.PRIMARY);
        setFocusPainted(false);
        setBorderPainted(false);
        setCursor(new Cursor(Cursor.HAND_CURSOR));
    }
}