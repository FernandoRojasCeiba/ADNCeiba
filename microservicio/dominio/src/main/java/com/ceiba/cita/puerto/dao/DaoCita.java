package com.ceiba.cita.puerto.dao;

import com.ceiba.cita.modelo.dto.DtoCita;

import java.util.List;

public interface DaoCita {

    /**
     * Permite consultar todas las citas existentes
     * @return lista de citas
     */
    List<DtoCita> consultarCitas();

    /**
     * Permite consultar citas por número de cédula
     * @param cedula
     * @return lista de citas
     */
    List<DtoCita> consultarPorCedula(String cedula);

    /**
     * Permite consultar una cita por ID
     * @param id
     * @return cita
     */
    DtoCita consultarPorID(Long id);


}
