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

    private static final Long ID_CITA = 1L;

    @Autowired
    private MockMvc mockMvc;

   @Test
    public void consultarCitas() throws Exception {
        // arrange

        // act - assert
        mockMvc.perform(get("/consultas")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void consultarCitasPorCedula() throws Exception{
        // Arrange

        String cedula = "1036946621";

        // Act - Assert
        mockMvc.perform(get("/consultas/{cedula}", cedula)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void consultarPorID() throws Exception{
        // Arrange

        // Act - Assert
        mockMvc.perform(get("/consultas/paciente/{id}", ID_CITA)
        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

}
