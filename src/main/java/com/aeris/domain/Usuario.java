package com.aeris.domain;

public class Usuario {

    private int idUsuario;
    private int idEmpresa;
    private String nombres;
    private String usuario;
    private String rol;
    private String estado;

    public Usuario() {}

    public Usuario(int idUsuario, int idEmpresa, String nombres, String usuario, String rol, String estado) {
        this.idUsuario = idUsuario;
        this.idEmpresa = idEmpresa;
        this.nombres = nombres;
        this.usuario = usuario;
        this.rol = rol;
        this.estado = estado;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(int idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}