/**
 * 深圳金融电子结算中心
 * Copyright (c) 1995-2017 All Rights Reserved.
 */
package com.murong.prepayment.cache.util;

/**
 * 操作系统类型判断工具类
 * @author lw.xu
 * @version $Id: OSUtil.java, v 0.1 2017年10月20日 上午9:27:57 lw.xu Exp $
 */
public class OSUtil {

    private static final String os = System.getProperty("os.name").toLowerCase();

    public static boolean isLinux() {
        return os.indexOf("linux") >= 0;
    }

    public static boolean isWindows() {
        return os.indexOf("windows") >= 0;
    }

}
