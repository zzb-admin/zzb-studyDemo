package com.zzb.demo;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.zzb.demo.entity.Persion;
import lombok.extern.slf4j.Slf4j;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ListStream {

    public static void test1(){
        List<String> listA = Arrays.asList("s1", "s2", "s3","s4", "s5", "s6","s7", "s8", "s9");
        List<String> listB = Arrays.asList("t1", "t2", "t3");

        // Stream.concat()实现多个流拼接
        Stream<String> streamA = Stream.concat(listA.stream(), listB.stream());

        // Stream.of()实现拼接
        // 多个元素
        Stream<String> streamB = Stream.of("A", "B", "C");
        // 多个List
        Stream<String> streamC = Stream.of(listA, listB).flatMap(Collection::stream);
        // 多个Stream
        Stream<String> streamD = Stream.of(listA.stream(), listB.stream()).flatMap(Function.identity());

        // flatMap实现子元素拼接
        List<Test10.Item> items = new ArrayList<>();
        Stream<String> streamE = items.stream().flatMap(i -> i.getSubItems().stream());

        List<String> collect = streamC.collect(Collectors.toList());
        System.out.println(collect);

        /*List<List<String>> partition = Lists.partition(listA, 2);
        System.out.println(partition);
        System.out.println("取出每组集合放入新的集合");
        List<String> stringList = Lists.newArrayList();
        partition.stream().forEach(list->
                stringList.addAll(list)
        );
        for (List<String> strings : partition) {
            for (String list2 : strings) {
                String replace = list2.replace(",", " ").replace("[", "").replace("]", "");
                System.out.print(replace);
            }
        }*/


    }

    public static String test2(int length){
        String str = "abcdefghijklmnopqrstuvwxyz";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<length;i++){
            int number = random.nextInt(26);
            sb.append(str.charAt(number));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Random random = new Random();
        int number = random.nextInt(26);
        System.out.println(number);
    }
}
