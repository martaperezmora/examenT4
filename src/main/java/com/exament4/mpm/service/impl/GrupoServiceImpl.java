package com.exament4.mpm.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exament4.mpm.model.Grupo;
import com.exament4.mpm.repository.GrupoRepository;
import com.exament4.mpm.service.GrupoService;

@Service
public class GrupoServiceImpl implements GrupoService {

    @Autowired
    GrupoRepository grupoRepository;

    @Override
    public List<Grupo> findAll() {
        return grupoRepository.findAll();
    }

    @Override
    public Grupo findById(int codigo) {
        Optional<Grupo> findById = grupoRepository.findById(codigo);
        if (findById != null) {
            return findById.get();
        }
        return null;
    }

    @Override
    public void insert(Grupo grupo) {
        grupoRepository.save(grupo);
    }

    @Override
    public void update(Grupo grupo) {
        grupoRepository.save(grupo);
    }

    @Override
    public void delete(int codigo) {
        grupoRepository.deleteById(codigo);
    }

}
