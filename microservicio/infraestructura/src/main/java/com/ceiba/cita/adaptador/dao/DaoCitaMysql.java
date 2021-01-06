package com.ceiba.cita.adaptador.dao;

import com.ceiba.cita.modelo.dto.DtoCita;
import com.ceiba.cita.puerto.dao.DaoCita;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DaoCitaMysql implements DaoCita {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace = "cita", value = "listar")
    private static String sqlListar;

    @SqlStatement(namespace = "cita", value = "listarxcedula")
    private static String sqlListaCedula;

    @SqlStatement(namespace = "cita", value = "listarxid")
    private static String sqlListaID;

    public DaoCitaMysql(CustomNamedParameterJdbcTemplate customJDBC){
        this.customNamedParameterJdbcTemplate = customJDBC;
    }


    @Override
    public List<DtoCita> consultarCitas() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListar, new MapeoCita());
    }

    @Override
    public List<DtoCita> consultarPorCedula(String cedula) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("cedula", cedula);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListaCedula, parameterSource, new MapeoCita());
    }

    @Override
    public DtoCita consultarPorID(Long id) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("id", id);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlListaID, parameterSource, new MapeoCita());
    }
}
