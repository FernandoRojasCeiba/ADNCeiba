package com.ceiba.cita.servicio;



import com.ceiba.BasePrueba;
import com.ceiba.cita.servicio.testdatabuilder.CitaTestDataBuilder;

import com.ceiba.dominio.excepcion.ExcepcionFechaNoValida;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.*;

public class ServicioActualizarCitaTest {


    @Test
    public void validarFechaActualizada() throws ParseException {
        // arrange
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date fechaNoValida = simpleDateFormat.parse("2020-12-19");
        CitaTestDataBuilder citaTestDataBuilder = new CitaTestDataBuilder().addFecha(fechaNoValida);
        // act - assert
        BasePrueba.assertThrows(() -> citaTestDataBuilder.build(), ExcepcionFechaNoValida.class, "La fecha seleccionada no puede ser sábado o domingo");
    }

}
