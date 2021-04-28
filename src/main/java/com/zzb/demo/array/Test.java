package com.zzb.demo.array;

import com.google.common.collect.Lists;
import org.apache.commons.lang.math.RandomUtils;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test {

    //如果return的数据是基本数据类型或文本字符串，则在finally中对该基本数据的改变不起作用，try中的return语句依然会返回进入finally块之前保留的值。
    public static int test(){
        int result=0;
        try {
            return 0;
        }catch (ArithmeticException e){
            System.out.println("被除数不能为0");
            return result;
        }finally {
            result++;
            return 1;
        }
    }

    //如果return的数据是引用数据类型，而在finally中对该引用数据类型的属性值的改变起作用，try中的return语句返回的就是在finally中改变后的该属性的值。

    public static void test1(){
        int result=0;
        int num=4;
        System.out.println(num/result);
    }

    //给出一个数组 把数组排序
    public static void test2(){
        int[] num = {1,3,4,2,6,5,7};
        for(int i=1;i<num.length;i++){
            for(int j=num.length-1;j>i;j--){
                if(num[j]<num[j-1]){
                    int temp=num[j];
                    num[j]=num[j-1];
                    num[j-1]=temp;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<num.length;i++){
            sb.append(num[i]+",");
        }
        String substring = "["+sb.substring(0, sb.length() - 1)+"]";
        System.out.println(substring);
    }

    //检测乱序问题 如果使用copyOnWriteArrayList可以保证线程安全且不乱序
    public static void coutDownLanchTest(){
        List<Integer> list = Lists.newCopyOnWriteArrayList();

        for(int i=0;i<1000;i++){
            list.add(i);
        }
        CountDownLatch countDownLatch = new CountDownLatch(1000);
        ExecutorService threadPool = Executors.newFixedThreadPool(1000);
        List<List<Integer>> partition = Lists.partition(list, 50);
        partition.stream().forEach(integerList->threadPool.submit(()->{
            System.out.println(integerList);
            countDownLatch.countDown();
        }));
        try {
            countDownLatch.await();
            threadPool.shutdown();
            while (!threadPool.isTerminated()){
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public static void main(String args[]) {
        coutDownLanchTest();
    }
}
