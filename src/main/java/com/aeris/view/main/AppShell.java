package com.aeris.view.main;

import com.aeris.ui.header.AerisHeader;
import com.aeris.ui.sidebar.AerisSidebar;
import com.aeris.ui.statusbar.AerisStatusBar;
import com.aeris.ui.theme.AerisTheme;
import com.aeris.view.modules.*;

import javax.swing.*;
import java.awt.*;

public class AppShell extends JPanel {

    private JPanel contentPanel;
    private AerisHeader header;

    public AppShell() {
        initComponents();
    }

    private void initComponents() {
        setLayout(new BorderLayout());
        setBackground(AerisTheme.BACKGROUND);

        header = new AerisHeader();
        AerisSidebar sidebar = new AerisSidebar(this);
        AerisStatusBar statusBar = new AerisStatusBar();

        contentPanel = new JPanel(new BorderLayout());
        contentPanel.setBackground(AerisTheme.BACKGROUND);

        add(header, BorderLayout.NORTH);
        add(sidebar, BorderLayout.WEST);
        add(contentPanel, BorderLayout.CENTER);
        add(statusBar, BorderLayout.SOUTH);

        mostrarDashboard();
    }

    private void mostrarPanel(JPanel panel, String titulo) {
        header.setBreadcrumb(titulo);

        contentPanel.removeAll();
        contentPanel.add(panel, BorderLayout.CENTER);
        contentPanel.revalidate();
        contentPanel.repaint();
    }

    public void mostrarDashboard() {
        mostrarPanel(new DashboardPanel(), "Dashboard");
    }

    public void mostrarClientes() {
        mostrarPanel(new ClientesPanel(), "Dashboard > Clientes");
    }

    public void mostrarRecursos() {
        mostrarPanel(new RecursosPanel(), "Dashboard > Recursos");
    }

    public void mostrarReservas() {
        mostrarPanel(new ReservasPanel(), "Dashboard > Reservas");
    }

    public void mostrarPagos() {
        mostrarPanel(new PagosPanel(), "Dashboard > Pagos");
    }

    public void mostrarReportes() {
        mostrarPanel(new ReportesPanel(), "Dashboard > Reportes");
    }

    public void mostrarAdministracion() {
        mostrarPanel(new AdministracionPanel(), "Dashboard > Administración");
    }

    public void mostrarAyuda() {
        mostrarPanel(new AyudaPanel(), "Dashboard > Ayuda");
    }
}