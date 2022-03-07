package com.example.sales.common.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormat {
    public static String getCurrentTime(){
        SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return date.format(new Date(System.currentTimeMillis()));
    }
}
