package com.lxf.study.shiro.config.shiro;

import com.lxf.study.shiro.config.shiro.realm.CustomRealm;
import java.util.List;
import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.cache.MemoryConstrainedCacheManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.session.SessionListener;
import org.apache.shiro.session.mgt.eis.SessionDAO;
import org.apache.shiro.spring.web.config.DefaultShiroFilterChainDefinition;
import org.apache.shiro.spring.web.config.ShiroFilterChainDefinition;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ShiroConfig {

  @Bean
  public Realm customRealm() {
    CustomRealm realm = new CustomRealm();
    // realm.setAuthenticationCachingEnabled(true);
    return realm;
  }

  @Bean
  public ShiroFilterChainDefinition shiroFilterChainDefinition() {
    DefaultShiroFilterChainDefinition chainDefinition = new DefaultShiroFilterChainDefinition();
    chainDefinition.addPathDefinition("/login", "anon");
    chainDefinition.addPathDefinition("/user/login", "anon");
    chainDefinition.addPathDefinition("/**", "authc");
    return chainDefinition;
  }

  @Bean
  public DefaultWebSessionManager sessionManager(SessionListener listener, SessionDAO sessionDAO) {
    DefaultWebSessionManager sessionManager = new DefaultWebSessionManager();
    // session超时时间 3分钟
    sessionManager.setGlobalSessionTimeout(3 * 60 * 1000);
    sessionManager.setSessionIdUrlRewritingEnabled(true);
    sessionManager.setSessionListeners(List.of(listener));
    sessionManager.setSessionDAO(sessionDAO);
    return sessionManager;
  }

  @Bean
  protected CacheManager cacheManager() {
    return new MemoryConstrainedCacheManager();
  }
}
