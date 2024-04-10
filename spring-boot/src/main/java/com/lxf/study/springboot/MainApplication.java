package com.lxf.study.springboot;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@Slf4j
@SpringBootApplication
public class MainApplication {

  public static void main(String[] args) {
    ConfigurableApplicationContext applicationContext =
        SpringApplication.run(MainApplication.class, args);
    /*String[] names = applicationContext.getBeanDefinitionNames();
    for (String name : names) {
      log.info("Bean名称：{}", name);
    }*/
  }
}
