package com.lxf.study.designmode.created.factory.simple;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Cat extends Animal {


    public Cat(String name) {
        super(name);
    }

    @Override
    public void sleep() {
        log.info("{}在睡觉", super.getName());
    }

    @Override
    public void eat() {
        log.info("{}在吃东西", super.getName());
    }
}
