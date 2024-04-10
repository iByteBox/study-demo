package com.lxf.study.springboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

  @RequestMapping("/hello111")
  public String hello() {
    return "hello spring boot!";
  }
}
