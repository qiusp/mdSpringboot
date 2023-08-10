package com.example.mdspringboot.common.util;

import cn.hutool.core.date.DateUtil;

import java.util.Date;
import java.util.Objects;

/**
 * 时间处理
 *
 * @author qiusp
 * @date 2022/02/17
 */
public class DateUtils {

    public static Date combineDateTime(Date date, String time) {
        String dateString = DateUtil.format(date, "yyyy-MM-dd");
        String dateTimeString = dateString + " " + time;
        return DateUtil.parse(dateTimeString);
    }

    public static Date getDate(Date datetime) {
        String dateString = DateUtil.format(datetime, "yyyy-MM-dd");
        return DateUtil.parse(dateString);
    }

    public static String getTimeAsString(Date datetime) {
        return DateUtil.format(datetime, "HH:mm:ss");
    }

    public static String setTimeFormat(String time) {
        Date datetime = DateUtil.parse(time);
        time = DateUtil.format(datetime, "HH:mm:ss");
        return time;
    }

    public static void main(String[] args){
        System.out.println(setTimeFormat("00:34"));
    }

    /**
     *
     * @param datetime
     * @param format:"HH:mm:ss",""yyyy-MM""
     * @return
     */
    public static String getTimeAsString(Date datetime, String format) {
        return Objects.isNull(datetime)? "" : DateUtil.format(datetime, format);
    }

}
