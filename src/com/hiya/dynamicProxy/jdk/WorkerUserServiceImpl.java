package com.hiya.dynamicProxy.jdk;

public class WorkerUserServiceImpl implements IUserService
{
    @Override
    public void add()
    {
        System.out.println("--------------------add  WorkerUserServiceImpl---------------");  
    }
}
