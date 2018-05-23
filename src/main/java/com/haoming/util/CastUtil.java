package com.haoming.util;

/**
 * Created by xiaot on 2018/5/18.
 */
public final class CastUtil {
    public static String castString(Object obj,String defaultValue){
        return obj != null ? String.valueOf(obj):defaultValue;
    }
    public static String castString(Object obj){
        return CastUtil.castString(obj,"");
    }

    public static double castDouble(Object obj,double defaultValue){
        double value=defaultValue;
        if(obj != null){
            String stringValue=castString(obj);
            if(StringUtil.isNotEmpty(stringValue)){
                value=Double.parseDouble(stringValue);
            }
        }
        return value;
    }

    public static double castDouble(Object obj){
        return castDouble(obj,0);
    }

    public static long castLong(Object obj,long defaultValue){
        long value=defaultValue;
        if(obj != null){
            String stringValue=castString(obj);
            if(StringUtil.isNotEmpty(stringValue)){
                value=Long.parseLong(stringValue);
            }
        }
        return value;
    }

    public static double castLong(Object obj){
        return castLong(obj,0);
    }

    public static int castInt(Object obj,int defaultValue){
        int value=defaultValue;
        if(obj != null){
            String stringValue=castString(obj);
            if(StringUtil.isNotEmpty(stringValue)){
                value=Integer.parseInt(stringValue);
            }
        }
        return value;
    }

    public static int castInt(Object obj){
        return castInt(obj,0);
    }

    public static boolean castBoolean(Object obj,boolean defaultValue){
        boolean value=defaultValue;
        if(obj != null){
            String stringValue=castString(obj);

            value=Boolean.parseBoolean(stringValue);

        }
        return value;
    }

    public static boolean castBoolean(Object obj){
        return castBoolean(obj,false);
    }
}
