package com.aeris.ui.crud;

import com.aeris.ui.button.AerisButton;

import javax.swing.*;
import java.awt.*;

public class CrudToolbar extends JPanel {

    public final AerisButton btnNuevo = new AerisButton("Nuevo");
    public final JButton btnEditar = new JButton("Editar");
    public final JButton btnEliminar = new JButton("Eliminar");
    public final JButton btnActualizar = new JButton("Actualizar");
    public final JTextField txtBuscar = new JTextField();

    public CrudToolbar() {
        setLayout(new BorderLayout());
        setOpaque(false);
        setBorder(BorderFactory.createEmptyBorder(16, 24, 16, 24));

        JPanel left = new JPanel(new FlowLayout(FlowLayout.LEFT, 8, 0));
        left.setOpaque(false);
        left.add(btnNuevo);
        left.add(btnEditar);
        left.add(btnEliminar);
        left.add(btnActualizar);

        txtBuscar.setPreferredSize(new Dimension(260, 36));
        txtBuscar.setToolTipText("Buscar...");

        add(left, BorderLayout.WEST);
        add(txtBuscar, BorderLayout.EAST);
    }
}