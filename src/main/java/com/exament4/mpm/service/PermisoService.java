package com.exament4.mpm.service;

import java.util.List;

import com.exament4.mpm.model.Permiso;

public interface PermisoService {
    public Permiso findById(int codigo);

    public List<Permiso> findAll();

    public void insert(Permiso permiso);

    public void update(Permiso permiso);

    public void delete(int codigo);
}
