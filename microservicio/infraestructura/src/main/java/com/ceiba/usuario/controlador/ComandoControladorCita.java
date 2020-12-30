package com.ceiba.usuario.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.usuario.comando.ComandoCita;
import com.ceiba.usuario.comando.manejador.ManejadorActualizarCita;
import com.ceiba.usuario.comando.manejador.ManejadorCrearCita;
import com.ceiba.usuario.comando.manejador.ManejadorEliminarCita;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/consultas")
@Api(tags = {"Controlador comando citas"})
public class ComandoControladorCita {

    private final ManejadorCrearCita manejadorCrearCita;
    private final ManejadorActualizarCita manejadorActualizarCita;
    private final ManejadorEliminarCita manejadorEliminarCita;

    @Autowired
    public ComandoControladorCita(ManejadorCrearCita handlerCrearCita, ManejadorActualizarCita handlerActualizarCita, ManejadorEliminarCita handlerEliminarCita){
        this.manejadorCrearCita = handlerCrearCita;
        this.manejadorActualizarCita = handlerActualizarCita;
        this.manejadorEliminarCita = handlerEliminarCita;
    }

    @PostMapping
    @ApiOperation("Crear Cita")
    public ComandoRespuesta<Long> crearCita(@RequestBody ComandoCita comandoCita){
        return manejadorCrearCita.ejecutar(comandoCita);
    }

    @PutMapping(value = "/{id}")
    @ApiOperation("Actualizar Cita")
    public void actualizarCita(@RequestBody ComandoCita comandoCita, @PathVariable Long id){
        comandoCita.setId_comando(id);
        manejadorActualizarCita.ejecutar(comandoCita);
    }

    @DeleteMapping(value = "/{id}")
    @ApiOperation("Eliminar Cita")
    public void eliminarCita(@PathVariable Long id){
        manejadorEliminarCita.ejecutar(id);
    }

}
