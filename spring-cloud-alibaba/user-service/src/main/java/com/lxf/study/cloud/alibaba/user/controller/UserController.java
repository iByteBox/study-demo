package com.lxf.study.cloud.alibaba.user.controller;

import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

  @Value("${server.port}")
  private int port;

  @GetMapping("/info")
  public Map<String, Object> info() {
    System.out.println("当前端口：" + port);
    Map<String, Object> data = new HashMap<>();
    data.put("id", 1000);
    data.put("account", "张三");
    return data;
  }
}
