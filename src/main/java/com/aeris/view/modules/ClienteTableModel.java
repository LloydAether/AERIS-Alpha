package com.aeris.view.modules;

import com.aeris.domain.Cliente;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class ClienteTableModel extends AbstractTableModel {

    private final String[] columnas = {
            "Código",
            "Documento",
            "Número",
            "Nombre / Razón Social",
            "Teléfono",
            "Estado"
    };

    private List<Cliente> clientes = new ArrayList<>();

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
        fireTableDataChanged();
    }

    public Cliente getCliente(int fila) {

        if (fila < 0 || fila >= clientes.size()) {
            return null;
        }

        return clientes.get(fila);

    }

    @Override
    public int getRowCount() {
        return clientes.size();
    }

    @Override
    public int getColumnCount() {
        return columnas.length;
    }

    @Override
    public String getColumnName(int column) {
        return columnas[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {

        Cliente cliente = clientes.get(rowIndex);

        return switch (columnIndex) {

            case 0 -> cliente.getCodigo();

            case 1 -> cliente.getTipoDocumento();

            case 2 -> cliente.getNumeroDocumento();

            case 3 -> cliente.getNombreRazonSocial();

            case 4 -> cliente.getTelefono();

            case 5 -> cliente.getEstado();

            default -> "";

        };

    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

}