package com.ceiba.cita.servicio.testdatabuilder;

import com.ceiba.cita.comando.ComandoCita;

import java.util.Date;
import java.util.UUID;

public class ComandoCitaTestDataBuilder {

    private Long id;
    private String cedula;
    private String nombre;
    private String apellido;
    private Date fechaCita;
    private int tipoCita;
    private int valor;

    public ComandoCitaTestDataBuilder(){
        cedula = "111122223333";
        nombre = UUID.randomUUID().toString();
        apellido = UUID.randomUUID().toString();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        fechaCita = simpleDateFormat.parse("2020-12-16");
        tipoCita = 1;
    }

    public ComandoCita build(){
        return new ComandoCita(id, cedula, nombre, apellido, fechaCita, tipoCita, valor);
    }

}
