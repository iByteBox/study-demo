package com.lxf.study.designmode.created.build;

public abstract class Builder {

  protected final Computer computer = new Computer();

  /* 安装主板 */
  public abstract void setMainBoard();

  /* 安装cpu */
  public abstract void setCpu();

  /*  安装内存条 */
  public abstract void setMemory();

  /* 安装固态硬盘 */
  public abstract void setSsd();

  public Computer build() {
    setMainBoard();
    setCpu();
    setMemory();
    setSsd();
    return computer;
  }
}
