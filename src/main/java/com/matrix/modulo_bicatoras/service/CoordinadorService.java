package com.matrix.modulo_bicatoras.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.matrix.modulo_bicatoras.exception.EntityNotFoundException;
import com.matrix.modulo_bicatoras.model.CoordinadorEntity;
import com.matrix.modulo_bicatoras.repository.CoordinadorRepository;

@Service
public class CoordinadorService {

    @Autowired
    private CoordinadorRepository coordinadorRepository;

    @Transactional
    public List<CoordinadorEntity> findAll() {
        return coordinadorRepository.findAll();
    }

    @Transactional
    public CoordinadorEntity save(CoordinadorEntity coordinadorEntity) {
        return coordinadorRepository.save(coordinadorEntity);
    }

    @Transactional
    public CoordinadorEntity findById(Integer id) throws EntityNotFoundException {
        Optional<CoordinadorEntity> coordinadorEntity = coordinadorRepository.findById(id);
        if (coordinadorEntity.isEmpty()){
            throw new EntityNotFoundException("Ningun registro encontrado con el id: " + id);
        }
        return coordinadorEntity.get();
    }

    @Transactional
    public CoordinadorEntity updateById(Integer id, CoordinadorEntity coordinadorEntity) throws EntityNotFoundException {
        Optional<CoordinadorEntity> coordinador = coordinadorRepository.findById(id);
        if (coordinador.isEmpty()){
            throw new EntityNotFoundException("Ningun registro encontrado con el id: " + id);
        }
        coordinadorEntity.setIdentificacion(id);

        return coordinadorRepository.save(coordinadorEntity);
    }

    @Transactional
    public void deleteById(Integer id) throws EntityNotFoundException {
        Optional<CoordinadorEntity> coordinador = coordinadorRepository.findById(id);
        if (coordinador.isEmpty()){
            throw new EntityNotFoundException("Ningun registro encontrado con el id: " + id);
        }
        coordinadorRepository.deleteById(id);
    }

    
}
