package com.haoming.util;

/**
 * Created by xiaot on 2018/5/18.
 */
public final class StringUtil {
    public static boolean isEmpty(String str){
        if(str != null){
            str=str.trim();
        }
      return StringUtil.isEmpty(str);
    }

    public static boolean isNotEmpty(String str){
        return !isEmpty(str);
    }
}
