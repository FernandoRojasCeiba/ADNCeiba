package com.ceiba.usuario.puerto.dao;

import com.ceiba.usuario.modelo.dto.DtoCita;

import java.util.List;

public interface DaoCita {

    /**
     * Permite listar citas
     * @return las citas
     */
    List<DtoCita> listarCitas();

}
