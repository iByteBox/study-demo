package com.lxf.study.simplecase.jdkproxy;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * InvocationHandler: jdk自带的调用处理器
 */
@Slf4j
public class CustomInvocationHandler implements InvocationHandler {

    public final Object target;

    public CustomInvocationHandler(Object target) {
        this.target = target;
    }

    /**
     * 此方法由生成的代理类调用，代理类持有InvocationHandler的引用
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        log.info("代理类：{}", proxy.getClass());
        log.info(method.getName());
        Object result = method.invoke(proxy, args);
        log.info("执行完毕");
        return result;
    }
}
