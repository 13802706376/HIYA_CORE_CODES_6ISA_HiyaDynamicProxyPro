package com.hiya.dynamicProxy.mybatis2;

@HiyaMyBatis
public interface IComputer
{
    String query();
    void delete();
    void insert();
    void update();
}
