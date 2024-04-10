package com.lxf.study.designmode.created.build;

import lombok.Data;

@Data
public class Computer {

    private Cpu cpu;

    private Memory memory;

    private Mainboard mainboard;

    private Ssd ssd;

    public void configInfo() {
        System.out.println("主板：" + mainboard.getName());
        System.out.println("CPU：" + cpu.getName());
        System.out.println("内存条：" + memory.getName());
        System.out.println("硬盘：" + ssd.getName());

    }

}
