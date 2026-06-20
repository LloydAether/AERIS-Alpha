package com.aeris.view.modules;

import com.aeris.service.ClienteService;
import com.aeris.ui.crud.CrudTable;
import com.aeris.ui.crud.CrudToolbar;
import com.aeris.ui.theme.AerisTheme;

import javax.swing.*;
import java.awt.*;

public class ClientesPanel extends JPanel {

    private final ClienteService service;

    private final ClienteTableModel tableModel;

    private final JTable table;

    private final CrudToolbar toolbar;

    public ClientesPanel() {

        service = new ClienteService();

        tableModel = new ClienteTableModel();

        table = new JTable(tableModel);

        toolbar = new CrudToolbar();

        initComponents();

        cargarClientes();

        eventos();

    }

    private void initComponents() {

        setLayout(new BorderLayout());

        setBackground(AerisTheme.BACKGROUND);

        JLabel titulo = new JLabel("Clientes");

        titulo.setFont(new Font("Segoe UI", Font.BOLD, 28));

        titulo.setBorder(BorderFactory.createEmptyBorder(20,24,10,24));

        add(titulo,BorderLayout.NORTH);

        JPanel centro = new JPanel(new BorderLayout());

        centro.setOpaque(false);

        centro.add(toolbar,BorderLayout.NORTH);

        centro.add(new CrudTable(table),BorderLayout.CENTER);

        add(centro,BorderLayout.CENTER);

    }

    private void cargarClientes(){

        tableModel.setClientes(

                service.listarClientes()

        );

    }

    private void buscar(){

        tableModel.setClientes(

                service.buscarClientes(

                        toolbar.txtBuscar.getText()

                )

        );

    }

    private void eventos(){

        toolbar.txtBuscar.getDocument().addDocumentListener(

                new javax.swing.event.DocumentListener() {

                    @Override
                    public void insertUpdate(javax.swing.event.DocumentEvent e) {
                        buscar();
                    }

                    @Override
                    public void removeUpdate(javax.swing.event.DocumentEvent e) {
                        buscar();
                    }

                    @Override
                    public void changedUpdate(javax.swing.event.DocumentEvent e) {
                        buscar();
                    }

                }

        );

        toolbar.btnActualizar.addActionListener(

                e->cargarClientes()

        );

    }

}