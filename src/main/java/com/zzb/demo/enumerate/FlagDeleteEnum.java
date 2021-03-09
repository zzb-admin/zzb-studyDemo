package com.zzb.demo.enumerate;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.google.common.collect.Maps;
import lombok.AllArgsConstructor;

import java.util.Map;

/**
 * @author monkey
 */
@AllArgsConstructor
public enum FlagDeleteEnum {

    NO(1,"未删除"),
    YES(2,"已删除"),
    UN_KNOWN(0,"未知");

    public Integer code;
    public String msg;

    private static Map<Integer,FlagDeleteEnum> maps = Maps.newHashMap();

    static{
        for (FlagDeleteEnum flagDeleteEnum : FlagDeleteEnum.values()) {
            maps.put(flagDeleteEnum.getCode(),flagDeleteEnum);
        }
    }
    @JsonCreator
    public static FlagDeleteEnum of(Integer code){
        if(null == maps.get(code)){
            return FlagDeleteEnum.UN_KNOWN;
        }
        return maps.get(code);
    }


    public Integer getCode(){
        return code;
    }

    @JsonValue
    public String getMsg(){
        return msg;
    }
}
