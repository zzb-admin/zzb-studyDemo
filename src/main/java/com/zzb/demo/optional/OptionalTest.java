package com.zzb.demo.optional;

import com.google.common.collect.Lists;
import org.apache.commons.lang.math.RandomUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @program: study-demo01-List-Stream
 * @description: optional测试
 * @author: monkey.zhao
 * @create: 2021-06-10 15:20
 **/
public class OptionalTest {

    public static void main(String[] args) {
        /*OptionalTest optionalTest = new OptionalTest();
        Integer value1 = null;
        Integer value = RandomUtils.nextInt(10);
        Boolean expected = Optional.of(Optional.ofNullable(value1).equals(1)).get();
        if (expected) {
            System.out.println("当if中判断条件为true 我可以做");
        }
        System.out.println("但是条件为false，我可以做");
        Integer a = Optional.ofNullable(value1).orElseGet(() -> orElseGetSomeThing());
        Integer b = Optional.ofNullable(value).orElseGet(() -> orElseGetSomeThing());
        System.out.println(optionalTest.sum(a, b));*/

        Integer num=0;
        Integer num1=-1;
        System.out.println(num * num1);
    }

    /**
     * 本地实现使用optional实现数值相加
     * 起一个方法
     * 两个参数 分别是 a和b
     * a为null
     * b为有效参数
     *
     * @param a
     * @param b
     */
    public Integer sum(Integer a, Integer b) {
        Integer sumNum = a + b;
        return sumNum;
    }


    /**
     * @Description: orElseGet实现为false需要实现的内容
     * @return: jave.lang.Integer
     * @author: monkey.zhao
     **/
    public static Integer orElseGetSomeThing() {
        return 999;
    }

    public static Optional<List<Integer>> optionalTestList() {
        List<Integer> idList = Lists.newArrayList();
        idList.add(RandomUtils.nextInt(10));
        Integer next = idList.iterator().next();
        return Optional.ofNullable(idList);
    }


}
