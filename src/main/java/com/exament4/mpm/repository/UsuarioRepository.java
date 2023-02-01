package com.exament4.mpm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exament4.mpm.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
    
}
