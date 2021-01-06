package com.ceiba.cita.comando.manejador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.cita.comando.ComandoCita;
import com.ceiba.cita.comando.fabrica.FabricaCita;
import com.ceiba.cita.modelo.entidad.Cita;
import com.ceiba.cita.servicio.ServicioCrearCita;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import org.springframework.stereotype.Component;

@Component
public class ManejadorCrearCita implements ManejadorComandoRespuesta<ComandoCita, ComandoRespuesta<Long>> {

    private final FabricaCita factoryCita;
    private final ServicioCrearCita serviceCrearCita;

    public ManejadorCrearCita(FabricaCita fabCita, ServicioCrearCita sevCrearCita){
        this.factoryCita = fabCita;
        this.serviceCrearCita = sevCrearCita;
    }

    public ComandoRespuesta<Long> ejecutar(ComandoCita comCita){
        Cita cita = this.factoryCita.crearCitaFactory(comCita);
        return new ComandoRespuesta<>(this.serviceCrearCita.ejecutarCrearCita(cita));
    }

}
