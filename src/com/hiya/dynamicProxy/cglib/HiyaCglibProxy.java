package com.hiya.dynamicProxy.cglib;

import java.lang.reflect.Method;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class HiyaCglibProxy implements MethodInterceptor
{
    private String name;

    public HiyaCglibProxy(String name)
    {
        this.name = name;
    }

    public Object intercept(Object object, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable
    {
        if (!name.equals("张三"))
        {
            System.out.println("权限不够");
            return null;
        }
        Object result = methodProxy.invokeSuper(object, objects);
        System.out.println("这是方法后");
        return result;
    }
}