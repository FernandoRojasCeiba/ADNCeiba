package com.ceiba.cita.servicio;

import com.ceiba.cita.modelo.entidad.Cita;
import com.ceiba.cita.servicio.testdatabuilder.CitaTestDataBuilder;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.*;

public class CitaTest {

    private static final Long ID_CITA = 2L;
    private static final String CEDULA_PACIENTE = "123456789";
    private static final String NOMBRE_PACIENTE = "Fernando";
    private static final String APELLIDO_PACIENTE = "Rojas";
    private static final int TIPO_CITA = 3;

    @Test
    public void creandoCitaTest() throws ParseException {
        // Arrange
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date fechaCita = simpleDateFormat.parse("2020-12-23");

        CitaTestDataBuilder citaTestDataBuilder = new CitaTestDataBuilder()
                .porID(ID_CITA)
                .porCedula(CEDULA_PACIENTE)
                .conNombre(NOMBRE_PACIENTE)
                .conApellido(APELLIDO_PACIENTE)
                .addFecha(fechaCita)
                .addTipoCita(TIPO_CITA)
                .addValorCita(0);

        // Act
        Cita cita = citaTestDataBuilder.build();

        // Assert
        assertEquals(ID_CITA, cita.getId());
        assertEquals(CEDULA_PACIENTE, cita.getCedula());
        assertEquals(NOMBRE_PACIENTE, cita.getNombre());
        assertEquals(APELLIDO_PACIENTE, cita.getApellido());
        assertEquals(cita.getFechaCita(), cita.getFechaCita());
        assertEquals(TIPO_CITA, cita.getTipoCita());
        assertEquals(9000, cita.getValor());
    }

}
