package com.ceiba.cita.consulta;

import com.ceiba.cita.modelo.dto.DtoCita;
import com.ceiba.cita.puerto.dao.DaoCita;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorListarCitas {

    private final DaoCita daoCita;

    public ManejadorListarCitas(DaoCita dataAccessObjectCita){
        this.daoCita = dataAccessObjectCita;
    }

    public List<DtoCita> ejecutarListCita(){
        return this.daoCita.consultarCitas();
    }

    public List<DtoCita> ejercutarCitaPorCedula(String cedula) {
        return this.daoCita.consultarPorCedula(cedula);
    }

    public DtoCita executeForID(Long id) { return this.daoCita.consultarPorID(id); }

}
