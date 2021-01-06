package com.ceiba.cita.puerto.repositorio;

import com.ceiba.cita.modelo.entidad.Cita;

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
    void actualizarCita(Cita cita);

    /**
     * Permite eliminar una cita
     * @param id de cita que se va a eliminar
     */
    void eliminarCita(Long id);


    /**
     * Permite validar si el tipo de cita que se está agendando ya existe
     * @param cedula
     * @param tipoCita
     * @return si existe el mismo tipo de cita para el paciente
     */
    boolean existeMismoTipoCita(String cedula, int tipoCita);
}
