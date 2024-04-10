package com.lxf.study.designmode.created.factory.method;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Dog extends Animal {
    @Override
    public void sleep() {
        log.info("小狗在睡觉");
    }

    @Override
    public void eat() {
        log.info("小狗在骨头");
    }
}
