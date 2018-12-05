package com.hiya.dynamicProxy.mybatis;

@HiyaMyBatis
public interface IComputer
{
    String query();
    void delete();
    void insert();
    void update();
}
