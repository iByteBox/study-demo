package com.lxf.study.shiro.config.shiro.session;

import cn.hutool.core.util.IdUtil;
import com.alibaba.fastjson2.JSON;
import java.io.Serializable;
import java.util.Collection;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.UnknownSessionException;
import org.apache.shiro.session.mgt.eis.SessionDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class CustomSessionDAO implements SessionDAO {

  @Autowired private StringRedisTemplate redisTemplate;

  @Override
  public Serializable create(Session session) {
    String key = IdUtil.fastSimpleUUID();
    redisTemplate.opsForValue().set(key, JSON.toJSONString(session));
    return key;
  }

  @Override
  public Session readSession(Serializable sessionId) throws UnknownSessionException {
    String session = redisTemplate.opsForValue().get(sessionId);
    return JSON.to(Session.class, session);
  }

  @Override
  public void update(Session session) throws UnknownSessionException {}

  @Override
  public void delete(Session session) {
    // redisTemplate.delete(session.getId());
  }

  @Override
  public Collection<Session> getActiveSessions() {
    return null;
  }
}
