package com.hiya.dynamicProxy.cglib;
import net.sf.cglib.proxy.Enhancer;
public class BookServiceFactory
{
    private BookServiceFactory()
    {

    }

    public static BookServiceBean getProxyInstance(HiyaCglibProxy myProxy)
    {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(BookServiceBean.class);
        enhancer.setCallback(myProxy);
        return (BookServiceBean) enhancer.create();
    }
}
