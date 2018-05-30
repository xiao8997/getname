package com.haoming.util;

import java.util.Properties;

/**
 * Created by xiaot on 2018/5/29.
 */
public final class ConfigHelper {
    private static final Properties CONFIG_PROPS=PropsUtil.loadProps(Constants.CONFIG_FILE);

    public static String getAppBasePackage(){
        return PropsUtil.getString(CONFIG_PROPS,Constants.APP_BASE_PACKAGE);
    }

    public static String getAppJspPath(){
        return PropsUtil.getString(CONFIG_PROPS,Constants.APP_JSP_PATH);
    }

    public static String getAppAssetPath(){
        return PropsUtil.getString(CONFIG_PROPS,Constants.APP_ASSET_PATH);
    }
}
