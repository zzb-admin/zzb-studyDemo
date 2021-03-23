package com.zzb.demo.enumerate;

import lombok.AllArgsConstructor;

import java.util.Map;

/**
 * @author monkey
 */
@AllArgsConstructor
public enum FlagDeleteEnum {

    NO(1, "未删除"),
    YES(2, "已删除"),
    UN_KNOWN(0, "未知");

    public Integer code;
    public String msg;


}
