package com.ceiba.cita.servicio;

import com.ceiba.cita.modelo.entidad.Cita;
import com.ceiba.cita.puerto.repositorio.RepositorioCita;
import com.ceiba.dominio.excepcion.ExcepcionTipoCitaExistente;

public class ServicioCrearCita {

    private static final String VALIDACION_TIPO_CITA_EXISTENTE = "No se puede agendar citas del mismo tipo";

    private final RepositorioCita repositorioCita;

    public ServicioCrearCita(RepositorioCita repoCita){
        this.repositorioCita = repoCita;
    }

    public Long ejecutarCrearCita(Cita cita){
        validarExistenciaTipoCita(cita);
        return  this.repositorioCita.crearCita(cita);
    }

    private void validarExistenciaTipoCita(Cita cita){
        boolean existeRegistro = this.repositorioCita.existeMismoTipoCita(cita.getCedula(), cita.getTipoCita());
        if(existeRegistro){
            throw new ExcepcionTipoCitaExistente(VALIDACION_TIPO_CITA_EXISTENTE);
        }
    }
}
