package com.lxf.study.designmode.created.factory.method;

/**
 * 工厂方法模式
 */
public class ClientApp {

    public static void main(String[] args) {
        AnimalFactory factory = new DogFactory();
        Animal dog = factory.createAnimal();
        dog.sleep();
        dog.eat();
    }

}
