package com.lxf.study.simplecase.io;

import cn.hutool.core.util.RandomUtil;
import java.io.*;
import java.nio.charset.StandardCharsets;

public class FileDemo {

  public static void main(String[] args) throws IOException, InterruptedException {
    File file = new File("temp/a.txt");
    Thread t0 =
        new Thread(
            () -> {
              byte[] bytes = new byte[20];
              try (FileInputStream is = new FileInputStream(file)) {
                while (!Thread.interrupted()) {
                  while (is.read(bytes) != -1) {
                    System.out.println(new String(bytes).trim());
                  }
                  Thread.sleep(2000);
                }
              } catch (IOException | InterruptedException e) {
                throw new RuntimeException(e);
              }
            });

    Thread t1 =
        new Thread(
            () -> {
              try (FileOutputStream os = new FileOutputStream(file, true)) {
                while (!Thread.interrupted()) {
                  String randomString = RandomUtil.randomString(RandomUtil.randomInt(20));
                  os.write(randomString.getBytes(StandardCharsets.UTF_8));
                  os.write('\n');
                  Thread.sleep(1000);
                }
              } catch (IOException | InterruptedException e) {
                throw new RuntimeException(e);
              }
            });
    t1.start();
    t0.start();
    Thread.sleep(10000);
    t0.interrupt();
    t1.interrupt();
  }
}
