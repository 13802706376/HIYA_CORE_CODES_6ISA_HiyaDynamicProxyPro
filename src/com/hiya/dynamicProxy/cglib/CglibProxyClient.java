package com.hiya.dynamicProxy.cglib;

public class CglibProxyClient
{
    public static void main(String[] args)
    {
        BookServiceBean service = BookServiceFactory.getProxyInstance(new HiyaCglibProxy("уехЩ"));
        service.create();
        service.query();
    }
}
