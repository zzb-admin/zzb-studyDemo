package com.zzb.demo;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.zzb.demo.entity.Persion;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
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

    /**
     * 排序成map
     */
    public static void test3(){
        List<Persion> list = new ArrayList<>();
        list.add(new Persion(1, "liquidweb.com", 80000));
        list.add(new Persion(2, "linode.com", 90000));
        list.add(new Persion(3, "digitalocean.com", 120000));
        list.add(new Persion(4, "aws.amazon.com", 200000));
        list.add(new Persion(5, "mkyong.com", 1));
        Map<String, Integer> collect =  list.stream()
                .sorted(Comparator.comparingLong(Persion::getAge).reversed())
                .collect(
                        Collectors.toMap(
                                Persion::getUsername, Persion::getAge, // key = name, value = websites
                                (oldValue, newValue) -> oldValue,       // if same key, take the old key
                                LinkedHashMap::new                      // returns a LinkedHashMap, keep order
                        ));
        System.out.println(collect);
    }

    public static  void test(){
        Stream<String> stream = Stream.of("I", "love", "you", "too");

        stream.collect(
                Collectors.toMap(
                        x->x,
                        String::length
                ));
        Map<String, Integer> collect = stream.collect(
                Collectors.toMap(
                        x->x,
                        String::length
                ));
        System.out.println(collect);
    }

    /**
     *  重复key问题
     */
    public static void test4(){
        List<Persion> list = new ArrayList<>();
        list.add(new Persion(1, "liquidweb.com", 80000));
        list.add(new Persion(2, "linode.com", 90000));
        list.add(new Persion(3, "digitalocean.com", 120000));
        list.add(new Persion(4, "aws.amazon.com", 200000));
        list.add(new Persion(5, "mkyong.com", 1));
        list.add(new Persion(6, "mkyong.com", 1));
        list.add(new Persion(7, "mkyong.com", 1));
        list.add(new Persion(8, "mkyong.com", 1));
        list.add(new Persion(9, "mkyong.com", 1));

        Map<String, Integer> collect = list.stream().collect(Collectors.toMap(Persion::getUsername, Persion::getAge,(oldvalue,newvalue)->newvalue ));
        Map<Integer, String> collect1 = list.stream()
                .collect(
                        Collectors.toMap(
                                persion -> persion.getAge(), persion -> persion.getUsername(),(oldvalue,newvalue)->newvalue)
                );
        System.out.println(collect1);
    }

    /**
     * 划分集合true false
     */
    public static void test5(){
        List<Persion> list = new ArrayList<>();
        list.add(new Persion(1, "liquidweb.com", 80000));
        list.add(new Persion(2, "linode.com", 90000));
        list.add(new Persion(3, "digitalocean.com", 120000));
        list.add(new Persion(4, "aws.amazon.com", 200000));
        list.add(new Persion(5, "mkyong.com", 1));

        Map<Boolean, List<Persion>> collect = list.stream()
                .collect(
                        Collectors.partitioningBy(persion -> persion.getAge() >= 80000)
                );

        List<Persion> persion_true = collect.get(true);
        List<Persion> persion_error = collect.get(false);
        System.out.println(persion_true);
        System.out.println(persion_error);
    }


    /**
     * 根据部门汇总数据
     */
    public static void test6(){
        List<Persion> list = new ArrayList<>();
        list.add(new Persion(1, "liquidweb.com", 80000));
        list.add(new Persion(2, "linode.com", 90000));
        list.add(new Persion(3, "digitalocean.com", 120000));
        list.add(new Persion(4, "aws.amazon.com", 200000));
        list.add(new Persion(5, "mkyong.com", 1));
        list.add(new Persion(1, "mkyong.com", 1));

        Map<Integer, Integer> collect = list.stream()
                .collect(
                        Collectors.groupingBy(persion -> persion.getId(), Collectors.summingInt(
                                Persion::getAge)
                        )
                );
        System.out.println(collect);
    }

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
     * 冒泡排序
     */
    public static void test7(int num[]){
        for(int i=0;i<num.length-1;i++){
            for(int j=0;j<num.length-1-i;j++){
                if(num[j]>num[j+1]){
                    int temp=num[j];
                    num[j]=num[j+1];
                    num[j+1]=temp;
                }
            }
        }
        for (int i : num) {
            System.out.print(i+",");
        }
    }




    public static void main(String[] args) {
        TestDate2();
    }


}
