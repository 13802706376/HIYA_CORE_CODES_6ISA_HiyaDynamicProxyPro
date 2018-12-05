package com.hiya.dynamicProxy.jdk;

/**
 * ��̬����ͨ�����ڶ�ԭ��ҵ���߼������䡣������ж�������ĳ���࣬�����������е�ĳЩ������Ȼ�����ĳ��ԭ�򣬱����¼��־����ӡ����ִ��ʱ�䣬�����ֲ��ý���Щ�߼�д�����
 * ���ķ����
���Կ��Դ���һ��������ʵ�ֺͶ���������ͬ�ķ�����ͨ���ô����������ʵ����Ȼ����ԭ�����е��ô����෽�������ﵽ���������Ҫҵ���߼���Ŀ�ġ�
����ʵҲ���Ǵ���ģʽ��һ��ʵ�֣�ͨ������ʵ����ķ�װ����ʵ����չ�ԡ�
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
