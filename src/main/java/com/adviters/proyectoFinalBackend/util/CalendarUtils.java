package com.adviters.proyectoFinalBackend.util;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class CalendarUtils {

    //Get available days in date range
    public static Integer getAvailableDaysInDateRange(Date startDate, Date endDate, List<Date> holidays){

        Calendar parsedStartDate = dateToCalendar(startDate);
        Calendar parsedEndDate = dateToCalendar(endDate);

        //Start accumulator.
        int availableDays = 0;

        while (parsedStartDate.before(parsedEndDate) || parsedStartDate.equals(parsedEndDate)) {

            //Check if the date is an available day.
            if (isAvailableDay(parsedStartDate.getTime(), holidays)) availableDays++;

            //Go to the next day
            parsedStartDate.add(Calendar.DATE, 1);
        }

        return availableDays;
    }

    private static boolean isAvailableDay(Date date, List<Date> holidays) {

        //Check if date is saturday or sunday
        if (!isWeekDay(date)) return false;

        //Compare the date for each holiday
        for (Date holiday : holidays){

            //Settings for compare in same format.
            holiday = dateToCalendar(holiday).getTime();
            date.setHours(0);
            holiday.setHours(0);

            //Check if the date is a holiday
            if (date.equals(holiday)) return false;
        }

        return true;

    }

    private static boolean isWeekDay(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        Integer weekDay = calendar.get(Calendar.DAY_OF_WEEK); //Get what day is
        return weekDay != Calendar.SATURDAY && weekDay != Calendar.SUNDAY;
    }


    public static Calendar dateToCalendar(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar;
    }

    public static Date toDate(LocalDate localDate) {
        return Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
    }

    public static LocalDate toLocalDate(Date date) {
        return Instant.ofEpochMilli(date.getTime()).atZone(ZoneId.systemDefault()).toLocalDate();
    }
}
