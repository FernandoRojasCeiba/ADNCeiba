package com.ceiba.usuario.servicio;

import com.ceiba.usuario.modelo.entidad.Cita;
import com.ceiba.usuario.puerto.repositorio.RepositorioCita;

public class ServicioCrearCita {

    private final RepositorioCita repositorioCita;

    public ServicioCrearCita(RepositorioCita repoCita){
        this.repositorioCita = repoCita;
    }

    public Long ejecutarCrearCita(Cita cita){
        return  this.repositorioCita.crearCita(cita);
    }

}
