package com.hiya.dynamicProxy.mybatis2;

import java.io.Serializable;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MapperProxy<T>  implements InvocationHandler,Serializable 
{
    private static final long serialVersionUID = 145646L;
    private final MapperExecutor mapperExecutor;
    private final Class<T> mapperInterface;
    
    
    public MapperProxy(MapperExecutor mapperExecutor, Class<T> mapperInterface)
    {
        this.mapperExecutor = mapperExecutor;
        this.mapperInterface = mapperInterface;
    }
    
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable
    {
        String name = mapperInterface.getClass().getName();
        System.out.println(name);
        return mapperExecutor.execute(proxy,method,args);
    }
}
