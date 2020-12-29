package com.ceiba.usuario.puerto.repositorio;

import com.ceiba.usuario.modelo.entidad.Cita;

public interface RepositorioCita {

    /**
     * Permite crear una cita
     * @param cita
     * @return id generado
     */
    Long crearCita(Cita cita);

    /**
     * Permite actualizar una cita
     * @param cita que se va a actualizar
     */
    //void actualizarCita(Cita cita);

    /**
     * Permite eliminar una cita
     * @param id de cita que se va a eliminar
     */
    //void eliminarCita(Long id);
}
