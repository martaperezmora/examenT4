package com.exament4.mpm.service;

import java.util.List;

import com.exament4.mpm.model.Usuario;

public interface UsuarioService {

    public List<Usuario> findAll();
    
    public Usuario findById(int codigo);

    public void insert(Usuario usuario);

    public void update(Usuario usuario);

    public void delete(int codigo);
}
