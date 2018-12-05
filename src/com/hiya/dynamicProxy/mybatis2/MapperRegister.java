package com.hiya.dynamicProxy.mybatis2;

import java.io.File;
import java.io.FileFilter;
import java.net.URL;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapperRegister<T>
{
    private final Map<Class<?>, MapperProxyFactory<?>> knownMappers = new HashMap<Class<?>, MapperProxyFactory<?>>();

    @SuppressWarnings("hiding")
    public <T> T getMapper(Class<T> type, MapperExecutor mapperExecutor)
    {
        @SuppressWarnings("unchecked")
        final MapperProxyFactory<T> mapperProxyFactory = (MapperProxyFactory<T>) knownMappers.get(type);
        if (null != mapperProxyFactory)
        {
            return mapperProxyFactory.newInstance(mapperExecutor);
        }
        return null;
    }

    @SuppressWarnings("hiding")
    public <T> boolean hasMapper(Class<T> type)
    {
        return knownMappers.containsKey(type);
    }

    @SuppressWarnings("hiding")
    public <T> void addMapper(Class<T> type)
    {
        if (type.isInterface())
        {
            if (hasMapper(type))
            {
                return;
            }
            knownMappers.put(type, new MapperProxyFactory<T>(type));
        }
    }

    public void addMappers(String packageName) throws Exception
    {
        List<Class<?>> classes = new ArrayList<Class<?>>();
        String packageDirName = packageName.replace('.', '/');
        Enumeration<URL> dirs = Thread.currentThread().getContextClassLoader().getResources(packageDirName);
        while (dirs.hasMoreElements())
        {
            URL url = dirs.nextElement();
            String protocol = url.getProtocol();
            if ("file".equals(protocol))
            {
                String filePath = URLDecoder.decode(url.getFile(), "UTF-8");
                findAndAddClassesInPackageByFile(packageName, filePath, true, classes);
            }
        }
        for (Class<?> mapperClass : classes)
        {
            addMapper(mapperClass);
        }
    }

    private static void findAndAddClassesInPackageByFile(String packageName, String packagePath,
            final boolean recursive, List<Class<?>> classes)
    {
        File dir = new File(packagePath);
        if (!dir.exists() || !dir.isDirectory())
        {
            return;
        }
        File[] dirfiles = dir.listFiles(new FileFilter()
        {
            public boolean accept(File file)
            {
                return (recursive && file.isDirectory()) || (file.getName().endsWith(".class"));
            }
        });
        for (File file : dirfiles)
        {
            if (file.isDirectory())
            {
                findAndAddClassesInPackageByFile(packageName + "." + file.getName(), file.getAbsolutePath(), recursive,
                        classes);
            } else
            {
                String className = file.getName().substring(0, file.getName().length() - 6);
                try
                {
                    Class<?> cla = Class.forName(packageName + '.' + className);
                    HiyaMyBatis hiyaMyBatis = (HiyaMyBatis) cla.getAnnotation(HiyaMyBatis.class);
                    if (null != hiyaMyBatis)
                    {
                        classes.add(cla);
                    }
                } catch (ClassNotFoundException e)
                {
                    e.printStackTrace();
                }
            }
        }
    }
}
