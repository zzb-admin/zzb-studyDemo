package com.zzb.demo;

import com.google.common.collect.Maps;

import java.time.*;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DateStudy {
    public static void TestDate1(){
        //now（）获取当前日期时间
        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();
        LocalDateTime localDateTime = LocalDateTime.now();//使用频率更高

        String s = localDate.toString();
        System.out.println(s);
    }

    public static void TestDate2(){
        //of()指定日期，没有偏移量
        LocalDateTime localDateTime = LocalDateTime.of(2021,1,1,12,12,12);
        System.out.println(localDateTime.toString().replace("T"," "));//2021-01-01T12:12:12
    }

    /**
     * 修改自身
     */
    public static void TestDate4(){
        //不可变性，不影响本身时间
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);//2021-02-27T22:35:09.096

        LocalDateTime localDateTime1 = localDateTime.withDayOfMonth(13);//修改为本月的多少天
        System.out.println(localDateTime1);//2021-02-13T22:35:09.096

//        LocalDateTime localDateTime1 = localDateTime.withDayOfMonth(40);
//        System.out.println(localDateTime1);
//        java.time.DateTimeException: 不能超过范围
//        Invalid value for DayOfMonth (valid values 1 - 28/31): 40

        LocalDateTime localDateTime2 = localDateTime.withDayOfYear(35);//修改为本年的多少天
        System.out.println(localDateTime2);//2021-02-04T22:35:09.096

        LocalDateTime localDateTime3 = localDateTime.withHour(2);//修改小时
        System.out.println(localDateTime3);//2021-02-04T02:35:09.096

    }

    /**
     * 在原有的基础上 增加
     */
    public void TestDate5(){
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);//2021-02-27T22:44:33.848

        LocalDateTime localDateTime1 = localDateTime.plusHours(2);
        System.out.println(localDateTime1);//2021-02-28T00:44:33.848

        LocalDateTime localDateTime2 = localDateTime.minusDays(5);
        System.out.println(localDateTime2);//2021-02-22T22:46:27.612

    }

    public void test1(){
        //时间戳
        Instant instant = Instant.now();
        System.out.println(instant);//2021-02-27T15:41:40.496Z，标准时间

        OffsetDateTime offsetDateTime = instant.atOffset(ZoneOffset.ofHours(8)); //添加偏移量
        System.out.println(offsetDateTime);//2021-02-27T23:41:40.496+08:00，东八区


        long milli = instant.toEpochMilli();//获取自1970/1/1/00:00:00 开始的毫秒数
        System.out.println(milli);//1614440500496

        Instant instant1 = Instant.ofEpochMilli(1614439220460L); //通过给定毫秒数，返回时间
        System.out.println(instant1);//2021-02-27T15:20:20.460Z
    }



    public static void main(String[] args) {

    }
}
