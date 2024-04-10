package com.lxf.study.designmode.created.factory.simple;

/**
 * 简单工厂模式
 * 缺点：当需要新增一个产品时，需要修改工厂类，违反了开闭原则
 */
public class AnimalSimpleFactory {

    public Animal created(String type) {
        if (type.equals("mimi")) {
            return new Cat("mimi");
        }
        if (type.equals("dahuang")) {
            return new Dog("dahuang");
        }
        return null;
    }

}
