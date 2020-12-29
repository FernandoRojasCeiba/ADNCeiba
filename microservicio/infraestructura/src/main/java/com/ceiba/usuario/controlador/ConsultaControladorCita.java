package com.ceiba.usuario.controlador;

import com.ceiba.usuario.consulta.ManejadorListarCitas;
import com.ceiba.usuario.modelo.dto.DtoCita;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/consulta", method = RequestMethod.GET)
@Api(tags = {"Controlador consulta citas"})
public class ConsultaControladorCita {

    private final ManejadorListarCitas manejadorListarCitas;

    public ConsultaControladorCita(ManejadorListarCitas handlerListarCitas){
        this.manejadorListarCitas = handlerListarCitas;
    }

    @GetMapping
    @ApiOperation("Listar Citas")
    public List<DtoCita> listarCitas(){
        return this.manejadorListarCitas.ejecutarListCita();
    }

}
