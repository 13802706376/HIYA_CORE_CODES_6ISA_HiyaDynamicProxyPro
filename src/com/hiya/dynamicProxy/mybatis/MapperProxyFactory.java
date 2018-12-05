package com.hiya.dynamicProxy.mybatis;
import java.lang.reflect.Proxy;
public class MapperProxyFactory<T>
{
    private Class<T> mapperInterface;
    public MapperProxyFactory(Class<T> mapperInterface) {
        this.mapperInterface = mapperInterface;
      }
    
    @SuppressWarnings("unchecked")
    public T newInstance(MapperExecutor mapperExecutor)
    {
        final MapperProxy<T> mapperProxy = new MapperProxy<T>(mapperExecutor, mapperInterface);
        return (T) Proxy.newProxyInstance(mapperInterface.getClassLoader(), new Class[]{ mapperInterface }, mapperProxy);
    }
}
