package com.lxf.study.designmode.created.factory.simple;

/**
 * 简单工厂模式
 */
public class ClientApp {

    public static void main(String[] args) {

        /* 简单工厂模式 */
        AnimalSimpleFactory simpleFactory = new AnimalSimpleFactory();
        Animal animal = simpleFactory.created("mimi");
        animal.sleep();
        animal.eat();
    }

}
