package com.banquito.core.pasivo.agencias.controller.dto;

import java.util.ArrayList;
import java.util.List;

import com.banquito.core.pasivo.agencias.model.Agencia;

public class AgenciaMapper {
    
    public static AgenciaRS mapToAgenciaRS(Agencia agencia) {
        return AgenciaRS.builder()
                .id(agencia.getId())
                .codigo(agencia.getCodigo())
                .nombre(agencia.getNombre()).build();
    }

    public static Agencia mapToAgencia(AgenciaRQ agenciaRQ) {
        Agencia agencia = new Agencia();
        agencia.setCodigo(agenciaRQ.getCodigo());
        agencia.setNombre(agencia.getNombre());
        return agencia;
    }

    public static List<AgenciaRS> mapToAgenciasRS(List<Agencia> agencias) {
        List<AgenciaRS> agenciasRS = new ArrayList<>();
        for (Agencia agencia : agencias) {
            agenciasRS.add(AgenciaMapper.mapToAgenciaRS(agencia));
        }
        return agenciasRS;
    }
}
