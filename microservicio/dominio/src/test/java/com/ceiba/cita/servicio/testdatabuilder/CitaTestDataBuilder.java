package com.ceiba.cita.servicio.testdatabuilder;

import com.ceiba.cita.modelo.entidad.Cita;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CitaTestDataBuilder {

    private Long id;
    private String cedula;
    private String nombre;
    private String apellido;
    private Date fechaCita;
    private int tipoCita;
    private int valor;

    public CitaTestDataBuilder() throws ParseException {
        cedula = "8888888";
        nombre = "Fernando";
        apellido = "Rojas";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        fechaCita = simpleDateFormat.parse("2020-12-16");
        tipoCita = 2;
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

    public CitaTestDataBuilder conTipoYCedula(String cedula, int tipoCita){
        this.cedula = cedula;
        this.tipoCita = tipoCita;
        return this;
    }

    public CitaTestDataBuilder conTipoCita(int tipoCita){
        this.tipoCita = tipoCita;
        return this;
    }

    public Cita build(){
        return new Cita(id, cedula, nombre, apellido, fechaCita, tipoCita, valor);
    }

}
