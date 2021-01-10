package com.ceiba.cita.servicio;


import com.ceiba.BasePrueba;
import com.ceiba.cita.modelo.entidad.Cita;
import com.ceiba.cita.puerto.repositorio.RepositorioCita;
import com.ceiba.cita.servicio.testdatabuilder.CitaTestDataBuilder;
import com.ceiba.dominio.excepcion.ExcepcionFechaNoValida;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.*;

public class ServicioCrearCitaTest {

    private static final Long ID_CITA = 1L;

    private RepositorioCita repositorioCita;

    @Before
    public void setUp(){
        repositorioCita = Mockito.mock(RepositorioCita.class);
    }

    @Test
    public void crearCita() throws ParseException {
        // Arrange
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date fechaValida = simpleDateFormat.parse("2020-12-16");
        Cita cita = new CitaTestDataBuilder().porID(ID_CITA).build();
        Mockito.when(repositorioCita.crearCita(cita)).thenReturn(ID_CITA);
        ServicioCrearCita servicioCrearCita = new ServicioCrearCita(repositorioCita);

        //Act
        Long idCita = servicioCrearCita.ejecutarCrearCita(cita);

        //
        assertEquals(ID_CITA, idCita);
    }

    @Test
    public void valorCita() throws ParseException {
        // Arrange
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date fechaValida = simpleDateFormat.parse("2020-12-16");
        Cita cita = new CitaTestDataBuilder().porID(ID_CITA).build();
        Mockito.when(repositorioCita.crearCita(cita)).thenReturn(ID_CITA);
        ServicioCrearCita servicioCrearCita = new ServicioCrearCita(repositorioCita);

        //Act
        int valorCita = cita.getValor();

        //
        assertEquals(4500, valorCita);
    }

    @Test
    public void valorCitaDiaFestivo() throws ParseException {
        // Arrange
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date fechaValida = simpleDateFormat.parse("2020-12-23");
        Cita cita = new CitaTestDataBuilder().porID(ID_CITA).addFecha(fechaValida).build();
        Mockito.when(repositorioCita.crearCita(cita)).thenReturn(ID_CITA);
        ServicioCrearCita servicioCrearCita = new ServicioCrearCita(repositorioCita);

        //Act
        int valorCita = cita.getValor();

        //
        assertEquals(9000, valorCita);
    }

    

    @Test
    public void validarTipoCita() throws ParseException {
        CitaTestDataBuilder citaTestDataBuilder = new CitaTestDataBuilder().addTipoCita(0);

        BasePrueba.assertThrows(() -> citaTestDataBuilder.build(), ExcepcionValorInvalido.class, "Debe seleccionar el tipo de cita");
    }

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
