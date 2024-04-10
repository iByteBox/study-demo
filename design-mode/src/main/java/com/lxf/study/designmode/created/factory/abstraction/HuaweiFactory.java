package com.lxf.study.designmode.created.factory.abstraction;

public class HuaweiFactory implements Factory {
    @Override
    public Mobile createMobile() {
        return new HuaweiMobile();
    }

    @Override
    public Computer createComputer() {
        return new HuaweiComputer();
    }
}
