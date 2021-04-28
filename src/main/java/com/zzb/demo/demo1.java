package com.zzb.demo;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.util.*;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

public class demo1 {
    public static void test1() {
        Scanner scanner = new Scanner(System.in);

        int i = scanner.nextInt();

        switch (i){
            case 1:
                System.out.println("今天适合练腿");
                break;
            case 3:
                System.out.println("今天适合练膀子");
                break;
            case 4:
                System.out.println("今天适合练胸");
                break;
            case 5:
                System.out.println("今天适合练腹");
                break;
            case 6:
                System.out.println("今天适合练背");
                break;
            case 7:
                System.out.println("今天适合练拳击");
                break;
            default:
                System.out.println("您输入的数字有误.....");
                break;
        }
    }

    public static void test2(){
        int num[] = {23,32,122,21,12};

        Scanner scanner = new Scanner(System.in);
        int I = scanner.nextInt();
        for(int i=0;i<num.length;i++){
            if(num[i]==I){
                System.out.println("您输入的"+I+"在第"+(i+1)+"个位置");
            }
        }
    }

    public static void test3(){
        Scanner sc = new Scanner(System.in);
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();

        //临时变量
        int temp;
        temp=num1;
        num1=num2;

        System.out.println("num1="+num1+"num2="+temp);

    }

    public static void test4(){
        Calendar instance = Calendar.getInstance();
        Date time = instance.getTime();
        System.out.println(time);
    }

    public static void test5(){

        int num[] = {2,1,3,4,5,9};
        for(int i = num.length-1;i>0;i--){
            for(int j=num.length-1-i;j>0;j--){
                int temp = num[j];
                num[j]=num[j+1];
                num[j+1]=temp;
            }
        }

        for(int i=0;i<num.length;i++){
            System.out.print(num[i]+" ");
        }
    }

    /**
     * 验证码随机生成五位随机数
     */
    public static void test6(){
        String content="ABCDEFGHIJKLMNOPQRSTUVWHYZ";//创建23个大写字母的字符串

        content+=content.toLowerCase();//把大写字母转换成小写字母，相连接

        content+="0123456789";//连接0~9的数字。

        Random random = new Random();//创建一个随机数对象

        StringBuffer stringBuffer = new StringBuffer(5);//创建空间大小为5的StringBuilder对象

        for (int i = 0; i <5; i++) {
        char n=content.charAt(random.nextInt(content.length()));//截取一个从0到content.length()之间的字符，循环输出5个不同的字符，追加到一起
            stringBuffer.append(n);
        }
        System.out.println(stringBuffer.toString());//转成字符串输出5个字符
    }


    /**
     * 一个小球从100m高处自由落下，每次落地后反弹回原高度的一半再落下，求它在第10次落地时，共经过多少米？第10次反弹多高？
     */
    public static void test7(){
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1,"2020");

        String s = map.get("1");
        System.out.println(s);
    }

    public static void mapTest(){
        Map<Integer, String> concurrentMap = Maps.newConcurrentMap();
       /* concurrentMap.put(1,"a");
        concurrentMap.put(2,"b");
*/
        Map<Integer, String> hashMap = new Hashtable<>();
        hashMap.put(1,"a");
        hashMap.put(2,"b");
        concurrentMap.putAll(hashMap);
        System.out.println( concurrentMap.size());
    }

    public static void testLongMaxNum(){
        Double pow = Math.pow(2, 63);
        Long l = new Double(pow).longValue();
        System.out.println(l );
    }

    public static void disTest(){
        List<Integer> integers = Lists.newArrayList(1, 1, 1, 1, 2, 2, 2, 2);
        List<Integer> collect = integers.stream().distinct().collect(Collectors.toList());
        System.out.println(collect);
    }

    public static void main(String[] args) {
        disTest();
    }
}
