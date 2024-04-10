package com.lxf.study.designmode.created.singleton;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ClientApp {

  public static void main(String[] args) {
    new Thread(
            () -> {
              SingletonService s1 = SingletonService.getInstance();
              log.info("s1:{}", s1);
            })
        .start();

    new Thread(
            () -> {
              SingletonService s2 = SingletonService.getInstance();
              log.info("s2:{}", s2);
            })
        .start();
  }
}
