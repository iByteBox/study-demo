package com.lxf.study.designmode.created.build;

/**
 * 建造者模式
 * 由各个复杂的部分组装成一个完整的产品
 */
public class ClientApp {

    public static void main(String[] args) {
        Computer computer = new ComputerBuilder().build();
        computer.configInfo();
    }

}
