package com.lxf.study.cloud.alibaba.order.controller;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/order")
public class OrderController {

  @Autowired private RestTemplate restTemplate;

  @GetMapping("/created")
  public String created() {
    Map data = restTemplate.getForObject("http://user-service/user/info", Map.class);
    return "创建订单" + data;
  }
}
