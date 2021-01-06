package com.ceiba.cita.controlador;

import com.ceiba.ApplicationMock;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = ApplicationMock.class)
@WebMvcTest(ConsultaControladorCita.class)
public class ConsultarControladorCitaTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void consultarCitas() throws Exception {
        // arrange

        // act - assert
        mockMvc.perform(get("/consultas")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(0)));
    }

    @Test
    public void consultarPorID() throws Exception{
        //arrange
        Long id = 2L;

        //act - assert
        mockMvc.perform(get("/consultas/{id}", id)
        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void consultarPorCedula() throws Exception{
        //arrange
        String cedula = "111222333";

        //act - assert
        mockMvc.perform(get("/consultas/{cedula}", cedula)
        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

}
