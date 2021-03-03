package com.zzb.demo;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

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
    public static void main(String[] args) {
        test5();
    }
}
