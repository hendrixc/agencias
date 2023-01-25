package com.banquito.core.pasivo.agencias.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banquito.core.pasivo.agencias.exception.CRUDException;
import com.banquito.core.pasivo.agencias.model.Agencia;
import com.banquito.core.pasivo.agencias.service.AgenciaService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/v1/agencias")
public class AgenciaController {
    
    private AgenciaService service;

    public AgenciaController(AgenciaService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Agencia>> listarTodas() {
        log.info("Retorna las agencias registradas");
        List<Agencia> agencias = this.service.obtenerTodas();
        log.info("Retornando {} agencias", agencias.size());
        return ResponseEntity.ok(agencias); 
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<Agencia> obtenerAgenciaPorCodigo(@PathVariable(name = "codigo") String codigo) {
        log.info("Va a buscar agencia por codigo {}", codigo);
        Agencia agencia = this.service.obtenerPorCodigo(codigo);
        if (agencia!=null) {
            return ResponseEntity.ok(agencia);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<String> crear(@RequestBody Agencia agencia) {
        try {
            this.service.crear(agencia);
            return ResponseEntity.ok().build();
        } catch (CRUDException e) {
            log.error("Error al crear la agencia {}", e.getMessage(), e);
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{id}")
    public  ResponseEntity<String> actualizar(@RequestBody Agencia agencia, @PathVariable(name="id") String id) {
        return null;
    }
}
