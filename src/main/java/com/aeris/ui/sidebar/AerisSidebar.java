package com.aeris.ui.sidebar;

import com.aeris.core.SessionManager;
import com.aeris.config.CompanyConfig;
import com.aeris.ui.theme.AerisTheme;
import com.aeris.view.main.AppShell;

import javax.swing.*;
import java.awt.*;

public class AerisSidebar extends JPanel {

    private final AppShell appShell;

    public AerisSidebar(AppShell appShell) {
        this.appShell = appShell;
        initComponents();
    }

    private void initComponents() {
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(240, 0));
        setBackground(AerisTheme.SIDEBAR);

        JLabel logo = new JLabel(
                "<html><div style='text-align:center;'>◌<br><b>AERIS</b><br><span style='font-size:10px;'>Alpha</span></div></html>",
                SwingConstants.CENTER
        );
        logo.setForeground(Color.WHITE);
        logo.setFont(new Font("Segoe UI", Font.BOLD, 26));
        logo.setBorder(BorderFactory.createEmptyBorder(28, 0, 28, 0));

        JPanel menu = new JPanel(new GridLayout(8, 1, 0, 8));
        menu.setOpaque(false);
        menu.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

        menu.add(item(CompanyConfig.MODULE_DASHBOARD, () -> appShell.mostrarDashboard()));
        menu.add(item(CompanyConfig.MODULE_CLIENTS, () -> appShell.mostrarClientes()));
        menu.add(item(CompanyConfig.MODULE_RESOURCES, () -> appShell.mostrarRecursos()));
        menu.add(item(CompanyConfig.MODULE_RESERVATIONS, () -> appShell.mostrarReservas()));
        menu.add(item(CompanyConfig.MODULE_PAYMENTS, () -> appShell.mostrarPagos()));
        menu.add(item(CompanyConfig.MODULE_REPORTS, () -> appShell.mostrarReportes()));
        if (SessionManager.getUsuarioActual() != null 
                && "ADMIN".equals(SessionManager.getUsuarioActual().getRol())) {
            menu.add(item(CompanyConfig.MODULE_ADMIN, () -> appShell.mostrarAdministracion()));
        }
        menu.add(item(CompanyConfig.MODULE_HELP, () -> appShell.mostrarAyuda()));

        add(logo, BorderLayout.NORTH);
        add(menu, BorderLayout.CENTER);
    }

    private JButton item(String text, Runnable action) {
        JButton btn = new JButton(text);
        btn.setHorizontalAlignment(SwingConstants.LEFT);
        btn.setForeground(Color.WHITE);
        btn.setBackground(AerisTheme.SIDEBAR);
        btn.setFocusPainted(false);
        btn.setBorderPainted(false);
        btn.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btn.addActionListener(e -> action.run());
        return btn;
    }
}