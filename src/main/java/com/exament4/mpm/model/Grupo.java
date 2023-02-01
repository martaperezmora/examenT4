package com.exament4.mpm.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class Grupo {
    @Id
    @GeneratedValue
    private int codigo;

    private String nombre;

    @Transient
    private List<Usuario> usuarios;

    public Grupo(int codigo, String nombre, List<Usuario> usuarios) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.usuarios = usuarios;
    }

    public Grupo(int codigo) {
        this.codigo = codigo;
    }

    public Grupo() {
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

}
