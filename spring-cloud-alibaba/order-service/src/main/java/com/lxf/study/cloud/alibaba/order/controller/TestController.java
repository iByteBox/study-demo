package com.lxf.study.cloud.alibaba.order.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

  @GetMapping("/test")
  public String test() {
    System.out.println("测试...");
    return "test!";
  }
}
