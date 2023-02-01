package com.exament4.mpm.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Transient;

@Entity
public class Permiso {
    @Id
    @GeneratedValue
    private int codigo;

    private String nombre;
    private String descripcion;

    @Transient
    private boolean checked;

    @ManyToMany(mappedBy = "permisos")
    private List<Usuario> usuarios;

    public Permiso(int codigo, String nombre, String descripcion, boolean checked, List<Usuario> usuarios) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.checked = checked;
        this.usuarios = usuarios;
    }

    public Permiso(int codigo) {
        this.codigo = codigo;
    }

    public Permiso() {
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

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

}
