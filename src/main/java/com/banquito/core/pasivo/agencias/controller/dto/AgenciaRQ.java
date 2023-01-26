package com.banquito.core.pasivo.agencias.controller.dto;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AgenciaRQ implements Serializable{
    
    private String codigo;
    private String nombre;

}
