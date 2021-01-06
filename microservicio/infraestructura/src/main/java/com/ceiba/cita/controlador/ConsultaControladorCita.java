package com.ceiba.cita.controlador;

import com.ceiba.cita.consulta.ManejadorListarCitas;
import com.ceiba.cita.modelo.dto.DtoCita;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/consultas")
@Api(tags = {"Controlador consulta citas"})
public class ConsultaControladorCita {

    private final ManejadorListarCitas manejadorListarCitas;

    public ConsultaControladorCita(ManejadorListarCitas handlerListarCitas){
        this.manejadorListarCitas = handlerListarCitas;
    }

    @GetMapping
    @ApiOperation("Listar Citas")
    public List<DtoCita> consultarCitas(){
        return this.manejadorListarCitas.ejecutarListCita();
    }


    @GetMapping(value = "/{cedula}")
    @ApiOperation("Listar Citas Por Cedula")
    public List<DtoCita> consultarPorCedula(@PathVariable String cedula){
        return this.manejadorListarCitas.ejercutarCitaPorCedula(cedula);
    }


    @GetMapping(value = "/paciente/{id}")
    @ApiOperation("Prueba listar")
    public DtoCita consultarPorID(@PathVariable Long id){
        return this.manejadorListarCitas.executeForID(id);
    }

}
