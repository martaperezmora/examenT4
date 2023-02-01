package com.exament4.mpm.service.impl;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exament4.mpm.model.Permiso;
import com.exament4.mpm.repository.PermisoRepository;
import com.exament4.mpm.service.PermisoService;

@Service
public class PermisoServiceImpl implements PermisoService{
    @Autowired
    PermisoRepository permisoRepository;

    @Override
    public List<Permiso> findAll() {
        return permisoRepository.findAll();
    }

    @Override
    public Permiso findById(int codigo) {
        Optional<Permiso> findById = permisoRepository.findById(codigo);
        if(findById != null){
            return findById.get();
        }
        return null;
    }

    @Override
    public void insert(Permiso permiso) {
        permisoRepository.save(permiso);
    }

    @Override
    public void update(Permiso permiso) {
        permisoRepository.save(permiso);
    }

    @Override
    public void delete(int codigo) {
        permisoRepository.deleteById(codigo);
    }
}
