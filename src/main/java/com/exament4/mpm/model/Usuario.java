package com.exament4.mpm.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Usuario {
    @Id
    @GeneratedValue
    private int codigo;

    private String nombre;
    private String email;

    @ManyToOne
    private Grupo grupo;

    @ManyToMany
    @JoinTable(name = "usuario_permiso", joinColumns = {
            @JoinColumn(name = "usuario_codigo")
    }, inverseJoinColumns = {
            @JoinColumn(name = "permiso_codigo")
    })
    private List<Permiso> permisos;

    public Usuario(int codigo, String nombre, String email, List<Permiso> permisos) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.email = email;
        this.permisos = permisos;
    }

    public Usuario(int codigo) {
        this.codigo = codigo;
    }

    public Usuario() {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Permiso> getPermisos() {
        return permisos;
    }

    public void setPermisos(List<Permiso> permisos) {
        this.permisos = permisos;
    }

}
