package com.hiya.dynamicProxy.mybatis;

public class MybatisClient
{

    public static void main(String[] args) throws Exception
    {
        MapperRegister<IUser>  mr = new MapperRegister<IUser>();
        MapperExecutor mapperExecutor = new MapperExecutor();
        mr.addMappers("com.hiya.dynamicProxy.mybatis2");
        
        IUser iUser = (IUser) mr.getMapper(IUser.class, mapperExecutor);
        iUser.query();
        iUser.delete();
        iUser.insert();
    }
}
