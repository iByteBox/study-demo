package com.lxf.study.simplecase.jdkproxy;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Proxy;

/**
 * jdk动态代理案例
 * 原理：在运行时动态生成代理类的字节码
 */
@Slf4j
public class ClientApp {

    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        UserService proxy1 = (UserService) Proxy.newProxyInstance(ClientApp.class.getClassLoader(), new Class[]{UserService.class}, new CustomInvocationHandler(userService));
        UserService proxy2 = (UserService) Proxy.newProxyInstance(ClientApp.class.getClassLoader(), new Class[]{UserService.class}, new CustomInvocationHandler(userService));
        String result = proxy1.getUserInfo();
        log.info("执行结果：{}", result);
        log.info("proxy1:{},proxy2:{}", proxy1, proxy2);
    }

}
