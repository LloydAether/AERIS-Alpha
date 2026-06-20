package com.aeris.view.modules;

import com.aeris.ui.card.AerisCard;
import com.aeris.ui.theme.AerisTheme;
import javax.swing.*;
import java.awt.*;

public class DashboardPanel extends JPanel {

    public DashboardPanel() {
        setLayout(new BorderLayout());
        setBackground(AerisTheme.BACKGROUND);

        JPanel top = new JPanel(new GridLayout(2, 1));
        top.setBackground(AerisTheme.BACKGROUND);
        top.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));

        JLabel titulo = new JLabel("Dashboard");
        titulo.setFont(new Font("Segoe UI", Font.BOLD, 30));
        titulo.setForeground(AerisTheme.TEXT);

        JLabel subtitulo = new JLabel("Resumen general de la gestión");
        subtitulo.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        subtitulo.setForeground(AerisTheme.TEXT_SECONDARY);

        top.add(titulo);
        top.add(subtitulo);

        JPanel cards = new JPanel(new GridLayout(2, 2, 24, 24));
        cards.setBackground(AerisTheme.BACKGROUND);
        cards.setBorder(BorderFactory.createEmptyBorder(20, 30, 30, 30));

        cards.add(card("Ingresos cobrados", "S/ 8,540.00"));
        cards.add(card("Ingresos pendientes", "S/ 3,250.00"));
        cards.add(card("Clientes morosos", "5"));
        cards.add(card("Reservas próximas", "8"));

        add(top, BorderLayout.NORTH);
        add(cards, BorderLayout.CENTER);
    }

    private JPanel card(String titulo, String valor) {
        AerisCard card = new AerisCard();

        JLabel lblTitulo = new JLabel(titulo);
        lblTitulo.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        lblTitulo.setForeground(AerisTheme.TEXT_SECONDARY);

        JLabel lblValor = new JLabel(valor);
        lblValor.setFont(new Font("Segoe UI", Font.BOLD, 30));
        lblValor.setForeground(AerisTheme.TEXT);

        card.add(lblTitulo, BorderLayout.NORTH);
        card.add(lblValor, BorderLayout.CENTER);

        return card;
    }
}