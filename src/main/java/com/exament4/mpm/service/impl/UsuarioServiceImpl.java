package com.exament4.mpm.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exament4.mpm.model.Usuario;
import com.exament4.mpm.repository.UsuarioRepository;
import com.exament4.mpm.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService{
    @Autowired
    UsuarioRepository usuarioRepository;
    
    @Override
    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario findById(int codigo) {
        Optional<Usuario> findById = usuarioRepository.findById(codigo);
        if(findById != null){
            return findById.get();
        }
        return null;
    }

    @Override
    public void insert(Usuario usuario) {
        usuarioRepository.save(usuario);
    }

    @Override
    public void update(Usuario usuario) {
        usuarioRepository.save(usuario);
    }

    @Override
    public void delete(int codigo) {
        usuarioRepository.deleteById(codigo);
    }
}
