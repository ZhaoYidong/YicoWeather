package com.yico.weather.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * ---------------------------------------------------------------
 * Author: ZhaoYidong
 * Create: 2017/1/6 16:00
 * ---------------------------------------------------------------
 * Describe:
 * ---------------------------------------------------------------
 * Changes:
 * ---------------------------------------------------------------
 * 2017/1/6 16 : Create by ZhaoYidong
 * ---------------------------------------------------------------
 */
public class DateUtils {

    /**
     * 根据日期获得星期
     *
     * @param dateStr yyyy-MM-dd
     * @param type    返回数据类型：1024——>星期x；其它——>code
     * @return
     */
    public static String getWeekOfDate(String dateStr, int type) {
        SimpleDateFormat sdfInput = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        try {
            date = sdfInput.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return getWeekOfDate(date, type);
    }

    /**
     * 根据日期获得星期
     *
     * @param date Date类型
     * @param type 返回数据类型：1024——>星期x；其它——>code
     * @return
     */
    public static String getWeekOfDate(Date date, int type) {
        String[] weekDaysName = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int intWeek = calendar.get(Calendar.DAY_OF_WEEK) - 1;
        if (1024 == type)
            return weekDaysName[intWeek];
        else
            return intWeek + "";
    }


}
