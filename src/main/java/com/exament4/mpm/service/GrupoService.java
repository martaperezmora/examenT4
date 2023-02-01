package com.exament4.mpm.service;

import java.util.List;

import com.exament4.mpm.model.Grupo;

public interface GrupoService {

    public List<Grupo> findAll();
    
    public Grupo findById(int codigo);

    public void insert(Grupo grupo);

    public void update(Grupo grupo);

    public void delete(int codigo);
}
