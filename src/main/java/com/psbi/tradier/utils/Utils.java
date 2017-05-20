package com.psbi.tradier.utils;

import java.time.format.DateTimeFormatter;

/**
 * Created by Peter.Schmeltzer on 5/20/2017.
 */
public class Utils {

    public static String dateOfEpochMillis(long epochMillis) {
        final long millisPerDay = 1000 * 60 * 60 * 24;
        return java.time.LocalDate.ofEpochDay(epochMillis / millisPerDay).format(DateTimeFormatter.ISO_LOCAL_DATE);
    }

}
