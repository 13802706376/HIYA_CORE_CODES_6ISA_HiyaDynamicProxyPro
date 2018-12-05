package com.hiya.dynamicProxy.mybatis;

import java.lang.reflect.Method;

public class MapperExecutor
{
    public Object execute(Object proxy, Method method, Object[] args)
    {
        String mname = method.getName();
        if("QUERY".equalsIgnoreCase(mname))
        {
            System.out.println("EXECUTE QUERY......");
        }
        else if("DELETE".equalsIgnoreCase(mname))
        {
            System.out.println("EXECUTE DELETE......");
        }
        else if("ADD".equalsIgnoreCase(mname))
        {
            System.out.println("EXECUTE ADD......");
        }
        else if("UPDATE".equalsIgnoreCase(mname))
        {
            System.out.println("EXECUTE UPDATE......");
        }
        else
        {
            System.out.println("EXECUTE ......");
        }
        return null;
    }
}
