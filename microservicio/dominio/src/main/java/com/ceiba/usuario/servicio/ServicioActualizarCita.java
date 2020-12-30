package com.ceiba.usuario.servicio;

import com.ceiba.usuario.modelo.entidad.Cita;
import com.ceiba.usuario.puerto.repositorio.RepositorioCita;

public class ServicioActualizarCita {

    private final RepositorioCita repositorioCita;

    public ServicioActualizarCita(RepositorioCita repositorioCita){
        this.repositorioCita = repositorioCita;
    }

    public void ejecutarActualizar(Cita cita){
        this.repositorioCita.actualizarCita(cita);
    }

}
