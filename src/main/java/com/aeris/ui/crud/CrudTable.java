package com.aeris.ui.crud;

import javax.swing.*;
import java.awt.*;

public class CrudTable extends JScrollPane {

    private final JTable table;

    public CrudTable(JTable table) {
        this.table = table;
        setViewportView(table);
        setBorder(BorderFactory.createEmptyBorder(0, 24, 24, 24));

        table.setRowHeight(36);
        table.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        table.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 13));
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }

    public JTable getTable() {
        return table;
    }
}