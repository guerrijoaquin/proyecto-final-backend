package com.adviters.proyectoFinalBackend.util;

import com.adviters.proyectoFinalBackend.Model.Licencias.Licencia;

import java.sql.Date;
import java.util.Collections;

public class Validation {

    public static boolean isValidLicence(Licencia licencia) {

        Date startDate = licencia.getStartDate();
        Date endDate = licencia.getEndDate();
        Integer availableDaysInDateRange = CalendarUtils.getAvailableDaysInDateRange(startDate, endDate, Collections.emptyList());
        if (availableDaysInDateRange < 1) return false;


        licencia.setTotalAvailableDays(availableDaysInDateRange);
        return true;
    }
}
