package com.adviters.proyectoFinalBackend.util;

import com.adviters.proyectoFinalBackend.Model.Calendar.Feriado;
import com.adviters.proyectoFinalBackend.Model.Licencias.Licencia;
import com.adviters.proyectoFinalBackend.Model.Users.Usuario;

import java.time.LocalDate;
import java.util.*;

public class Validation {

    public static boolean isValidLicence(Licencia licencia, List<Feriado> feriados) {
        try {
            List<Date> holidays = new ArrayList<>();
            for (Feriado feriado : feriados){
                holidays.add(CalendarUtils.toDate(feriado.getDate()));
            }

            Date startDate = CalendarUtils.toDate(licencia.getStartDate());
            Date endDate = CalendarUtils.toDate(licencia.getEndDate());

            Integer availableDaysInDateRange = CalendarUtils.getAvailableDaysInDateRange(startDate, endDate, holidays);
            if (availableDaysInDateRange < 1) return false;

            licencia.setTotalAvailableDays(availableDaysInDateRange);
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }

    }

    public static boolean isValidUser(Usuario usuario){
        return true;
    }

    public static boolean isLegalAge(LocalDate date) {
        return true;
    }
}
