package com.lxf.study.simplecase.thread.synctools;

import java.util.concurrent.CountDownLatch;

/** 同步工具类 - CountDownLatch(闭锁)例子 */
public class CountDownLatchDemo {

  public static void main(String[] args) throws InterruptedException {
    System.out.println("Main线程执行");
    CountDownLatch latch = new CountDownLatch(3);

    for (int i = 0; i < 3; i++) {
      new Thread(
              () -> {
                System.out.println(Thread.currentThread().getName() + "-线程");
                latch.countDown();
                System.out.println(Thread.currentThread().getName() + "-线程-执行完毕...");
              })
          .start();
    }
    latch.await();
    System.out.println("Main线程执行完毕...");
  }
}
