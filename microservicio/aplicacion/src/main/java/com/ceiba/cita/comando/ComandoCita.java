package com.ceiba.cita.comando;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoCita {
    private Long id;
    private String cedula;
    private String nombre;
    private String apellido;
    private Date fechaCita;
    private int tipoCita;
    private int valor;
}
