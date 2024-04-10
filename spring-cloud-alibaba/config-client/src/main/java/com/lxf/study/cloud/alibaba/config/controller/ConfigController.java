package com.lxf.study.cloud.alibaba.config.controller;

import com.lxf.study.cloud.alibaba.config.config.Lxf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/config")
public class ConfigController {

  @Autowired private Lxf lxf;

  @GetMapping("/test")
  public String test() {
    return "test" + "\t" + lxf.getTest();
  }
}
