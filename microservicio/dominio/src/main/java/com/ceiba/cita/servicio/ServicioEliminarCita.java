package com.ceiba.cita.servicio;

import com.ceiba.cita.puerto.repositorio.RepositorioCita;

public class ServicioEliminarCita {

    private final RepositorioCita repositorioCita;

    public ServicioEliminarCita(RepositorioCita repositorioCita){
        this.repositorioCita = repositorioCita;
    }

    public void ejecutarEliminar(Long id){
        this.repositorioCita.eliminarCita(id);
    }

}
