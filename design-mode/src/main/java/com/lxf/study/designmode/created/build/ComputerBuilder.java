package com.lxf.study.designmode.created.build;

public class ComputerBuilder extends Builder {
  @Override
  public void setMainBoard() {
    computer.setMainboard(new Mainboard("微星主板-B650M"));
  }

  @Override
  public void setCpu() {
    computer.setCpu(new Cpu("AMD R7 7800X3D"));
  }

  @Override
  public void setMemory() {
    computer.setMemory(new Memory("金士顿 32GB DDR5 5000MHz"));
  }

  @Override
  public void setSsd() {
    computer.setSsd(new Ssd("三星 1TB M.2 NVMe SSD"));
  }
}
