package com.hiya.dynamicProxy.cglib;

public class BookServiceBean
{
    public BookServiceBean()
    {
        System.out.println("this is bookservicebean �Ĺ��췽��");
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
