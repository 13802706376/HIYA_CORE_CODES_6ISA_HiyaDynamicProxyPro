package com.hiya.dynamicProxy.jdk;

public class BossUserServiceImpl implements IUserService
{
    @Override
    public void add()
    {
        System.out.println("--------------------add boss---------------");  
    }
}
