package com.ceiba.cita.controlador;

import com.ceiba.ApplicationMock;
import com.ceiba.cita.comando.ComandoCita;
import com.ceiba.cita.servicio.testdatabuilder.ComandoCitaTestDataBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = ApplicationMock.class)
@WebMvcTest(ComandoControladorCita.class)
public class ComandoControladorCitaTest {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void crearCita() throws Exception{
        //arrange
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date fechaValida = simpleDateFormat.parse("2020-12-16");
        ComandoCita comandoCita = new ComandoCitaTestDataBuilder().conFecha(fechaValida).build();

        //act - assert
        mockMvc.perform(post("/consultas")
        .contentType(MediaType.APPLICATION_JSON)
        .content(objectMapper.writeValueAsString(comandoCita)))
                .andExpect(status().isOk())
                .andExpect(content().json("{'valor': 1}"));
    }

    @Test
    public void actualizarCita() throws Exception{
        //arrange
        Long id = 2L;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date fechaValida = simpleDateFormat.parse("2020-12-16");
        ComandoCita comandoCita = new ComandoCitaTestDataBuilder().conFecha(fechaValida).build();

        //act - assert
        mockMvc.perform(put("/consultas/{id}", id)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(comandoCita)))
                .andExpect(status().isOk());
    }

    @Test
    public void eliminarCita() throws Exception{
        //arrange
        Long id = 2L;

        //act - assert
        mockMvc.perform(delete("/consultas/{id}", id)
        .contentType(MediaType.APPLICATION_JSON)
        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }



}
