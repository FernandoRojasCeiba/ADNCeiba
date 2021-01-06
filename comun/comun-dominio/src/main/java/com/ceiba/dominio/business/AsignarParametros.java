package com.ceiba.dominio.business;

import com.ceiba.dominio.util.HolidayUtil;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;

public class AsignarParametros {

    public static final int VALOR_CITA = 4500;

    private AsignarParametros(){}

    public static Date AsignarFecha(Date fecha){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fecha);
        calendar.add(Calendar.DAY_OF_YEAR, 1);

        int dia = calendar.get(Calendar.DAY_OF_WEEK);

        Instant dia_seleccionado = fecha.toInstant();
        Instant dia_cita;
        if(dia == Calendar.FRIDAY){
            dia_cita = dia_seleccionado.plus(4, ChronoUnit.DAYS);
        } else {
            dia_cita = dia_seleccionado.plus(2, ChronoUnit.DAYS);
        }
        fecha = Date.from(dia_cita);

        return fecha;
    }

    public static int asignarValorCita(Date fecha)
    {

        int valorCita;

        final String DATE_FORMAT_INT = ("yyyyMMdd");
        String fechaFormateada = new SimpleDateFormat(DATE_FORMAT_INT).format(fecha);

        String fechaCompleta = Integer.toString(Integer.parseInt(fechaFormateada));

        int anio = Integer.parseInt(fechaCompleta.substring(0, 4));
        int mes = Integer.parseInt(fechaCompleta.substring(4, 6));
        int dia = Integer.parseInt(fechaCompleta.substring(6, 8));

        HolidayUtil festivos = new HolidayUtil(anio);

        boolean festivo = festivos.isHoliday(mes-1, dia);

        if (festivo){
                valorCita = VALOR_CITA*2;
        } else{
            valorCita =VALOR_CITA;
        }

        return valorCita;
    }

}


