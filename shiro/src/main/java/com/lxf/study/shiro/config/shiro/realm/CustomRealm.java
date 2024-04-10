package com.lxf.study.shiro.config.shiro.realm;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

@Slf4j
public class CustomRealm extends AuthorizingRealm {

  @Override
  protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
    log.info("权限认证");
    CacheManager manager = this.getCacheManager();

    //    Cache<Object, AuthenticationInfo> cache = this.getAuthenticationCache();
    //    cache
    //        .values()
    //        .forEach(
    //            (e) -> {
    //              log.info("Principals:{},Credentials:{}", e.getPrincipals(), e.getCredentials());
    //            });

    Set<String> roles = new HashSet<>();
    roles.add("admin");
    SimpleAuthorizationInfo info = new SimpleAuthorizationInfo(roles);
    List<String> permissions = new ArrayList<>();
    permissions.add("home");
    info.addStringPermissions(permissions);
    return info;
  }

  @Override
  protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token)
      throws AuthenticationException {
    log.info("身份认证");
    return new SimpleAuthenticationInfo("admin", "123", "custom");
  }
}
