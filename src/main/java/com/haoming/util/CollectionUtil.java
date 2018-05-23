package com.haoming.util;

import java.util.Collection;
import java.util.Map;

/**
 * Created by xiaot on 2018/5/18.
 */
public final class CollectionUtil {

    public static boolean isEmpty(Collection<?> collection){
        return CollectionUtil.isEmpty(collection);
    }

    public static boolean isNotEmpty(Collection<?> collection){
        return !CollectionUtil.isEmpty(collection);
    }

    public static boolean isEmpty(Map<?,?> map){
        return CollectionUtil.isEmpty(map);
    }

    public static boolean isNotEmpty(Map<?,?> map){
        return !CollectionUtil.isEmpty(map);
    }
}
