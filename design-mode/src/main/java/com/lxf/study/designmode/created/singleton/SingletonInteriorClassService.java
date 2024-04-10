package com.lxf.study.designmode.created.singleton;

/** 静态内部类实现单例模式-线程安全 */
public class SingletonInteriorClassService {

  private SingletonInteriorClassService() {}

  private static class SingletonHolder {
    private static final SingletonInteriorClassService INSTANCE =
        new SingletonInteriorClassService();
  }

  public static SingletonInteriorClassService getInstance() {
    return SingletonHolder.INSTANCE;
  }
}
