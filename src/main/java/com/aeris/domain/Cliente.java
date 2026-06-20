package com.aeris.domain;

public class Cliente {

    private int idCliente;
    private String codigo;
    private String tipoDocumento;
    private String numeroDocumento;
    private String nombreRazonSocial;
    private String telefono;
    private String direccion;
    private String estado;

    public Cliente(int idCliente, String codigo, String tipoDocumento, String numeroDocumento,
                   String nombreRazonSocial, String telefono, String direccion, String estado) {
        this.idCliente = idCliente;
        this.codigo = codigo;
        this.tipoDocumento = tipoDocumento;
        this.numeroDocumento = numeroDocumento;
        this.nombreRazonSocial = nombreRazonSocial;
        this.telefono = telefono;
        this.direccion = direccion;
        this.estado = estado;
    }

    public int getIdCliente() { return idCliente; }
    public String getCodigo() { return codigo; }
    public String getTipoDocumento() { return tipoDocumento; }
    public String getNumeroDocumento() { return numeroDocumento; }
    public String getNombreRazonSocial() { return nombreRazonSocial; }
    public String getTelefono() { return telefono; }
    public String getDireccion() { return direccion; }
    public String getEstado() { return estado; }
}