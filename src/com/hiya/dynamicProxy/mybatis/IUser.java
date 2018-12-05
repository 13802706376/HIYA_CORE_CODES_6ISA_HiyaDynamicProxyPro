package com.hiya.dynamicProxy.mybatis;

@HiyaMyBatis
public interface IUser
{
         String query();
         void delete();
         void insert();
         void update();
}
