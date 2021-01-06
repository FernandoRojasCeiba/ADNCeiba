package com.ceiba.dominio.excepcion;

public class ExcepcionTipoCitaExistente extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public ExcepcionTipoCitaExistente(String msj){
        super(msj);
    }

}
