package com.ceiba.usuario.comando.fabrica;

import com.ceiba.usuario.comando.ComandoCita;
import com.ceiba.usuario.modelo.entidad.Cita;
import org.springframework.stereotype.Component;

@Component
public class FabricaCita {

    public Cita crearCitaFactory(ComandoCita comandoCita){
        return new Cita(
                comandoCita.getId_comando(),
                comandoCita.getCedula_comando(),
                comandoCita.getNombre_comando(),
                comandoCita.getApellido_comando(),
                comandoCita.getFecha_comando()
        );
    }

}
