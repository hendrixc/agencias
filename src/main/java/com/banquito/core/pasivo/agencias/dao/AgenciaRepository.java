package com.banquito.core.pasivo.agencias.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.banquito.core.pasivo.agencias.model.Agencia;

public interface AgenciaRepository extends MongoRepository<Agencia, String>{
    
    Agencia findByCodigo(String codigo);
}
