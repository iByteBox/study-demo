package com.lxf.study.simplecase.thread.synctools;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

/** 同步工具类 - 信号量的使用 */
public class SemaphoreDemo {
  public static void main(String[] args) throws InterruptedException {
    Semaphore sem = new Semaphore(1);
    List<Integer> res = new ArrayList<>();
    // 信号量例子
    for (int i = 0; i < 10; i++) {
      new Thread(
              () -> {
                try {
                  sem.acquire();
                  System.out.println(Thread.currentThread().getName() + " 抢到车位");
                  Thread.sleep(2000);
                  System.out.println(Thread.currentThread().getName() + " 离开车位");
                  sem.release();
                } catch (InterruptedException e) {
                  e.printStackTrace();
                }
              })
          .start();
    }
    //    Thread.sleep(10000);
    //    System.out.println("程序结束");
    //    System.exit(0);
  }
}
