package com.hiya.dynamicProxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class HiyaJdkProxy implements InvocationHandler
{
    // 目标对象
    private Object target;

    /**
     * 构造方法
     * 
     * @param target
     *            目标对象
     */
    public HiyaJdkProxy(Object target)
    {
        super();
        this.target = target;
    }

    /**
     * 执行目标对象的方法
     */
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable
    {
        System.out.println("------------------before------------------");
        Object result = method.invoke(target, args);
        System.out.println("-------------------after------------------");
        return result;
    }

    /**
     * 获取目标对象的代理对象
     * 
     * @return 代理对象
     */
    public Object getProxy()
    {
        return Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), target.getClass().getInterfaces(), this);
    }
}
