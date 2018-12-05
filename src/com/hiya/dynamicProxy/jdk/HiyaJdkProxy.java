package com.hiya.dynamicProxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class HiyaJdkProxy implements InvocationHandler
{
    // Ŀ�����
    private Object target;

    /**
     * ���췽��
     * 
     * @param target
     *            Ŀ�����
     */
    public HiyaJdkProxy(Object target)
    {
        super();
        this.target = target;
    }

    /**
     * ִ��Ŀ�����ķ���
     */
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable
    {
        System.out.println("------------------before------------------");
        Object result = method.invoke(target, args);
        System.out.println("-------------------after------------------");
        return result;
    }

    /**
     * ��ȡĿ�����Ĵ������
     * 
     * @return �������
     */
    public Object getProxy()
    {
        return Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), target.getClass().getInterfaces(), this);
    }
}
