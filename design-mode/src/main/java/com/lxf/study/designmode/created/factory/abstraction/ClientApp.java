package com.lxf.study.designmode.created.factory.abstraction;

/**
 * 抽象工厂模式
 */
public class ClientApp {

    public static void main(String[] args) {
        // 创建小米工厂
        Factory factory = new XiaomiFactory();
        // 手机
        Mobile mobile = factory.createMobile();
        mobile.showBrand();
        // 电脑
        Computer computer = factory.createComputer();
        computer.showBrand();

        // 创建华为工厂
        factory = new HuaweiFactory();
        mobile = factory.createMobile();
        mobile.showBrand();
        computer = factory.createComputer();
        computer.showBrand();
    }

}
