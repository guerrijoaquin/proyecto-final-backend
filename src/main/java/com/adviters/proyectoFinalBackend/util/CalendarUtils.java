package com.adviters.proyectoFinalBackend.util;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;

public class CalendarUtils {

    //Obtener días laborales entre dos fechas
    public static Integer getAvailableDaysInDateRange(Date startDate, Date endDate, List<Date> listaFechasNoLaborables){

        Calendar parsedStartDate = dateToCalendar(startDate);
        Calendar parsedEndDate = dateToCalendar(endDate);

        int diffDays = 0;
        boolean diaHabil = false;
        //mientras la fecha inicial sea menor o igual que la fecha final se cuentan los dias
        while (parsedStartDate.before(parsedEndDate) || parsedStartDate.equals(parsedEndDate)) {

            if (!listaFechasNoLaborables.isEmpty()) {
                for (Date date : listaFechasNoLaborables) {
                    Date fechaNoLaborablecalendar = date;
                    //si el dia de la semana de la fecha minima es diferente de sabado o domingo
                    if (parsedStartDate.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY && parsedStartDate.get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY && !fechaNoLaborablecalendar.equals(date)) {
                        //se aumentan los dias de diferencia entre min y max
                        diaHabil = true;
                    } else {
                        diaHabil = false;
                        break;
                    }
                }
            } else {
                if (parsedStartDate.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY && parsedStartDate.get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY) {
                    //se aumentan los dias de diferencia entre min y max
                    diffDays++;
                }
            }
            if (diaHabil == true) {
                diffDays++;
            }
            //se suma 1 dia para hacer la validacion del siguiente dia.
            parsedStartDate.add(Calendar.DATE, 1);
        }
        return diffDays;
    }

    private static Calendar dateToCalendar(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar;
    }
}
