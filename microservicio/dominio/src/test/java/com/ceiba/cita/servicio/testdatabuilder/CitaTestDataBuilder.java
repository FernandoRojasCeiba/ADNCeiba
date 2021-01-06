package com.ceiba.cita.servicio.testdatabuilder;

import com.ceiba.cita.modelo.entidad.Cita;

import java.util.Date;

public class CitaTestDataBuilder {

    private Long id;
    private String cedula;
    private String nombre;
    private String apellido;
    private Date fechaCita;
    private int tipoCita;
    private int valor;

    public CitaTestDataBuilder(){
        cedula = "111222333";
        nombre = "Fernando";
        apellido = "Rojas";
        fechaCita = new Date();
        tipoCita = 1;
    }

    public CitaTestDataBuilder porCedula(String cedula){
        this.cedula = cedula;
        return this;
    }

    public CitaTestDataBuilder porID(Long id){
        this.id = id;
        return this;
    }

    public CitaTestDataBuilder addFecha(Date fechaCita){
        this.fechaCita = fechaCita;
        return this;
    }

    public CitaTestDataBuilder addTipoCita(int tipoCita){
        this.tipoCita = tipoCita;
        return this;
    }

    public CitaTestDataBuilder addValorCita(int valor){
        this.valor = valor;
        return this;
    }

    public Cita build(){
        return new Cita(id, cedula, nombre, apellido, fechaCita, tipoCita, valor);
    }

}
