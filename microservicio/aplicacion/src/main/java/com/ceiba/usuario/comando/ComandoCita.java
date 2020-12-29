package com.ceiba.usuario.comando;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoCita {
    private Long id_comando;
    private String cedula_comando;
    private String nombre_comando;
    private String apellido_comando;
    private Date fecha_comando;
}
