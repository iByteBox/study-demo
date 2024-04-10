package com.lxf.study.shiro.config.shiro.session;

import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.SessionListenerAdapter;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class CustomSessionListenerAdapter extends SessionListenerAdapter {

  @Override
  public void onStart(Session session) {
    log.info("创建session");
  }

  @Override
  public void onStop(Session session) {
    log.info("停止session");
  }

  @Override
  public void onExpiration(Session session) {
    log.info("session到期");
  }
}
