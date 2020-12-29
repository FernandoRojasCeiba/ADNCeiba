package com.ceiba.usuario.consulta;

import com.ceiba.usuario.modelo.dto.DtoCita;
import com.ceiba.usuario.puerto.dao.DaoCita;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorListarCitas {

    private final DaoCita daoCita;

    public ManejadorListarCitas(DaoCita dataAccessObjectCita){
        this.daoCita = dataAccessObjectCita;
    }

    public List<DtoCita> ejecutarListCita(){
        return this.daoCita.listarCitas();
    }

}
