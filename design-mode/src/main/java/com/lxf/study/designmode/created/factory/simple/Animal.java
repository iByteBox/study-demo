package com.lxf.study.designmode.created.factory.simple;

public abstract class Animal {

    private String name;

    public Animal(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract void sleep();

    public abstract void eat();

}
