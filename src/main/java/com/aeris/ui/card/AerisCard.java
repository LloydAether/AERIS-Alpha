package com.aeris.ui.card;

import com.aeris.ui.theme.AerisTheme;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class AerisCard extends JPanel {

    public AerisCard() {
        setBackground(AerisTheme.CARD);
        setBorder(new EmptyBorder(24, 24, 24, 24));
        setLayout(new BorderLayout());
    }
}