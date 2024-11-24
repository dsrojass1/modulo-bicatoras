package com.matrix.modulo_bicatoras.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.matrix.modulo_bicatoras.model.CoordinadorEntity;

public interface CoordinadorRepository extends MongoRepository<CoordinadorEntity, Integer> {
    
}
