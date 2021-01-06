package com.ceiba.cita.servicio;

import com.ceiba.cita.modelo.entidad.Cita;
import com.ceiba.cita.puerto.repositorio.RepositorioCita;

public class ServicioActualizarCita {

    private final RepositorioCita repositorioCita;

    public ServicioActualizarCita(RepositorioCita repositorioCita){
        this.repositorioCita = repositorioCita;
    }

    public void ejecutarActualizar(Cita cita){
        this.repositorioCita.actualizarCita(cita);
    }

}
