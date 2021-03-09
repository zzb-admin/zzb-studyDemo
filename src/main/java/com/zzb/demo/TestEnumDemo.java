package com.zzb.demo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zzb.demo.enumerate.FlagDeleteEnum;

public class TestEnumDemo {

    public static void test1() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String s = mapper.writeValueAsString(FlagDeleteEnum.NO);
        System.out.println(s);
    }

    public static void test2() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String s = mapper.writeValueAsString(FlagDeleteEnum.of(0));
        System.out.println(s);
    }

    public static void main(String[] args) throws JsonProcessingException {
        test2();
    }
}
