package com.ceiba.usuario.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;

@Getter
@AllArgsConstructor
public class DtoCita {

    private Long id;
    private String cedula;
    private String nombre;
    private String apellido;
    private Date fechaCita;

}
