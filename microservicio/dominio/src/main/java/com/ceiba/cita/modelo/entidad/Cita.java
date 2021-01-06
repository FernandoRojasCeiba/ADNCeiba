package com.ceiba.cita.modelo.entidad;

import lombok.Getter;

import java.util.Date;

import static com.ceiba.dominio.ValidadorArgumento.*;
import static com.ceiba.dominio.business.AsignarParametros.AsignarFecha;
import static com.ceiba.dominio.business.AsignarParametros.asignarValorCita;

@Getter
public class Cita {

    private static final String VALIDACION_CEDULA = "Se debe ingresar el número de cédula";
    private static final String VALIDACION_NOMBRE = "Se debe ingresar el nombre del paciente";
    private static final String VALIDACION_APELLIDO = "Se debe ingresar el apellido del paciente";
    private static final String VALIDACION_FECHA_OBLIGATORIA = "Se debe ingresar la fecha de la cita";
    private static final String VALIDACION_FECHA = "La fecha seleccionada no puede ser sábado o domingo";
    private static final String VALIDACION_TIPO_CITA = "Debe seleccionar el tipo de cita";

    private Long id;
    private String cedula;
    private String nombre;
    private String apellido;
    private Date fechaCita;
    private int tipoCita;
    private int valor;

    public Cita(Long id, String cedula, String nombre, String apellido, Date fechaCita, int tipoCita, int valor) {
        validarObligatorio(cedula, VALIDACION_CEDULA);
        validarObligatorio(nombre, VALIDACION_NOMBRE);
        validarObligatorio(apellido, VALIDACION_APELLIDO);
        validarObligatorio(fechaCita, VALIDACION_FECHA_OBLIGATORIA);
        validarFecha(fechaCita, VALIDACION_FECHA);
        validarPositivo(Double.valueOf(tipoCita), VALIDACION_TIPO_CITA);

        fechaCita = AsignarFecha(fechaCita);
        valor = asignarValorCita(fechaCita);

        this.id = id;
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaCita = fechaCita;
        this.tipoCita = tipoCita;
        this.valor = valor;
    }
}
