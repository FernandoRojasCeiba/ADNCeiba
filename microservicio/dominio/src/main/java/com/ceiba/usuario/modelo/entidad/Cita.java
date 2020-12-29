package com.ceiba.usuario.modelo.entidad;

import lombok.Getter;

import java.util.Date;

import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

@Getter
public class Cita {

    private static final String VALIDACION_CEDULA = "Se debe ingresar el número de cédula";
    private static final String VALIDACION_NOMBRE = "Se debe ingresar el nombre del paciente";
    private static final String VALIDACION_APELLIDO = "Se debe ingresar el apellido del paciente";
    private static final String VALIDACION_FECHA_CITA = "Se debe ingresar la fecha de la cita";

    private Long id;
    private String cedula;
    private String nombre;
    private String apellido;
    private Date fechaCita;

    public Cita(Long id, String cedula, String nombre, String apellido, Date fechaCita) {
        validarObligatorio(cedula, VALIDACION_CEDULA);
        validarObligatorio(nombre, VALIDACION_NOMBRE);
        validarObligatorio(apellido, VALIDACION_APELLIDO);
        validarObligatorio(fechaCita, VALIDACION_FECHA_CITA);

        this.id = id;
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaCita = fechaCita;
    }
}