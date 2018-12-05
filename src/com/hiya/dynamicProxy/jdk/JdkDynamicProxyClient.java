package com.hiya.dynamicProxy.jdk;

/**
 * 静态代理通常用于对原有业务逻辑的扩充。比如持有二方包的某个类，并调用了其中的某些方法。然后出于某种原因，比如记录日志、打印方法执行时间，但是又不好将这些逻辑写入二方
 * 包的方法里。
所以可以创建一个代理类实现和二方方法相同的方法，通过让代理类持有真实对象，然后在原代码中调用代理类方法，来达到添加我们需要业务逻辑的目的。
这其实也就是代理模式的一种实现，通过对真实对象的封装，来实现扩展性。
 * @author zjq
 *
 */
public class JdkDynamicProxyClient
{
    public static void main(String[] args)
    { 
            HiyaJdkProxy invocationHandler = new HiyaJdkProxy(new StudentUserServiceImpl());  
            IUserService proxy = (IUserService) invocationHandler.getProxy();  
            proxy.add();  
            
            invocationHandler = new HiyaJdkProxy(new TeaterUserServiceImpl());  
            proxy = (IUserService) invocationHandler.getProxy();  
            proxy.add();  
            
            invocationHandler = new HiyaJdkProxy(new WorkerUserServiceImpl());  
            proxy = (IUserService) invocationHandler.getProxy();  
            proxy.add();
     }
}
