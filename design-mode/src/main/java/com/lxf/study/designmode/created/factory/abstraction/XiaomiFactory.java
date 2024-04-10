package com.lxf.study.designmode.created.factory.abstraction;

public class XiaomiFactory implements Factory {
    @Override
    public Mobile createMobile() {
        return new XiaomiMobile();
    }

    @Override
    public Computer createComputer() {
        return new XiomiComputer();
    }
}
