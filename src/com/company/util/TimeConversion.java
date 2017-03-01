package com.company.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * Created by ashish-mathur on 1/3/17.
 */
public class TimeConversion {
    private static DateFormat dfm = new SimpleDateFormat("yyyy/MM/dd HH:mm");
    private static Date date;

    public static Date getDate(String time)
    {
        dfm.setTimeZone(TimeZone.getTimeZone("GMT+5:30"));//Specify your timezone
        try
        {
            date = dfm.parse(time);
        }
        catch (ParseException e)
        {
            e.printStackTrace();
        }

        return date;
    }

}

