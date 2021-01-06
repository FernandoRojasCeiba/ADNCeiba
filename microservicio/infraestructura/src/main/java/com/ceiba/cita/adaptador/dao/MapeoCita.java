package com.ceiba.cita.adaptador.dao;

import com.ceiba.cita.modelo.dto.DtoCita;
import com.ceiba.infraestructura.jdbc.MapperResult;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class MapeoCita implements RowMapper<DtoCita>, MapperResult {

    @Override
    public DtoCita mapRow(ResultSet rs, int rowNum) throws SQLException {

        Long id = rs.getLong("id");
        String cedula = rs.getString("cedula");
        String nombre = rs.getString("nombre");
        String apellido = rs.getString("apellido");
        Date fechaCita = rs.getDate("fecha_cita");
        int tipoCita = rs.getInt("tipo_cita");
        int valor = rs.getInt("valor");

        return new DtoCita(id, cedula, nombre, apellido, fechaCita, tipoCita, valor);
    }

}
