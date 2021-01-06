package com.ceiba.cita.comando.fabrica;

import com.ceiba.cita.comando.ComandoCita;
import com.ceiba.cita.modelo.entidad.Cita;
import org.springframework.stereotype.Component;

@Component
public class FabricaCita {

    public Cita crearCitaFactory(ComandoCita comandoCita){
        return new Cita(
                comandoCita.getId(),
                comandoCita.getCedula(),
                comandoCita.getNombre(),
                comandoCita.getApellido(),
                comandoCita.getFechaCita(),
                comandoCita.getTipoCita(),
                comandoCita.getValor()
        );
    }

}
