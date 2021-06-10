package com.zzb.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Persion {
    private Integer id;

    private String username;

    private Integer age;

    private List<Integer> idList;
}
