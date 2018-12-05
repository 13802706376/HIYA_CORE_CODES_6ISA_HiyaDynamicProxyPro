package com.hiya.dynamicProxy.cglib;

public class BookServiceBean
{
    public BookServiceBean()
    {
        System.out.println("this is bookservicebean 的构造方法");
    }

    public void create()
    {
        System.out.println("create() is running!");
    }

    public void query()
    {
        System.out.println("query() is running!");
    }
}
