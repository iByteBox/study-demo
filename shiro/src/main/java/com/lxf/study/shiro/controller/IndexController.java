package com.lxf.study.shiro.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class IndexController {

  @RequiresPermissions("home")
  @RequestMapping("/index")
  public String index() {
    log.info("hello shiro!");
    return "hello shiro!";
  }

  @RequiresPermissions("admin")
  @RequestMapping("/admin")
  public String admin() {
    log.info("admin权限!");
    return "admin权限!";
  }

  @GetMapping("/user/login")
  public String login(@RequestParam String account, @RequestParam String password) {
    try {
      UsernamePasswordToken token = new UsernamePasswordToken(account, password);
      Subject currentUser = SecurityUtils.getSubject();
      currentUser.login(token);
      currentUser.checkPermission("home");
      Session session = currentUser.getSession();
      return "登录成功";
    } catch (Exception e) {
      log.error(e.getMessage(), e);
      return "登录失败";
    }
  }
}
