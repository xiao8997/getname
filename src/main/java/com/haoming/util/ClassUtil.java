package com.haoming.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;

import static com.sun.org.apache.bcel.internal.Repository.addClass;

/**
 * Created by xiaot on 2018/5/29.
 */
public final class ClassUtil {
    private final static Logger LOGGER= LoggerFactory.getLogger(ClassUtil.class);

    public static ClassLoader getClassLoader(){
        return Thread.currentThread().getContextClassLoader();
    }

    public static Class<?> loadClass(String className,boolean isinit){
        Class<?> cls;
        try {
            cls=Class.forName(className,isinit,getClassLoader());
        } catch (ClassNotFoundException e) {
            LOGGER.error("load class failure",e);
            throw new RuntimeException();
        }
        return cls;
    }

    public static Set<Class<?>> getClassSet(String packageName){
        Set<Class<?>> classSet= new HashSet<Class<?>>();
        try {
            Enumeration<URL> urls =getClassLoader().getResources(packageName.replace(".","/"));
            while (urls.hasMoreElements()){
                URL url=urls.nextElement();
                if(url !=null){
                    String protocol = url.getProtocol();
                    if(protocol.equals("file")){
                        String packagePath = url.getPath().replaceAll("%20","");
//                        addClass(classSet,packagePath,packageName);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return classSet;
    }
}
