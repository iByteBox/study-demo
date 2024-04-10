package com.lxf.study.shiro.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

  @GetMapping("/login")
  public String login() {
    return "请登录...";
  }

  @GetMapping("/notAuth")
  public String notAuth() {
    return "没有操作权限...";
  }
}
