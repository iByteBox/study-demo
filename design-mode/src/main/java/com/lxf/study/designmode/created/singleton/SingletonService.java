package com.lxf.study.designmode.created.singleton;

/** 单例模式-线程安全 双重检查锁定方式 注意：volatile关键字不能省略（保持内存可见性） */
public class SingletonService {

  private static volatile SingletonService instance = null;

  private SingletonService() {}

  public static SingletonService getInstance() {
    if (instance == null) {
      synchronized (SingletonService.class) {
        if (instance == null) {
          instance = new SingletonService();
        }
      }
    }
    return instance;
  }

  public void doSomething() {
    System.out.println("单例对象方法调用");
  }
}
