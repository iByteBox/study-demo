package com.lxf.study.simplecase.test;

import cn.hutool.core.date.DateUtil;

import java.util.Date;

public class Test {

    public Test() {
        this.demo();
    }

    public void demo() {
        System.out.println("构造函数测试");
    }

    public static void main(String[] args) {
        // Test test = new Test();

        double a = 2;  // 0 1 10  0 1 2
        double b = 2;
        double c = 0;

        Date now = new Date();

        DateUtil.offsetDay(now, 1);

        System.out.println();
        // System.out.println(c);

    }

}
