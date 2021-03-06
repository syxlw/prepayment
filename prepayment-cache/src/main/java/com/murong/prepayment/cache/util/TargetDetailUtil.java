/**
 * 深圳金融电子结算中心
 * Copyright (c) 1995-2017 All Rights Reserved.
 */
package com.murong.prepayment.cache.util;

import java.lang.reflect.Method;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;

/**
 * 获取切点类的详细信息工具类 
 * @author lw.xu
 * @version $Id: TargetDetailUtil.java, v 0.1 2017年10月26日 下午7:52:10 lw.xu Exp $
 */
public class TargetDetailUtil {

    /**
     * 获取切点方法
     */
    public static Method getMethod(ProceedingJoinPoint point) {
        MethodSignature signature = (MethodSignature) point.getSignature();
        return signature.getMethod();
    }

    /**
     * 获取切点方法的返回值类型
     */
    public static Class<?> getReturnType(ProceedingJoinPoint point) {
        MethodSignature signature = (MethodSignature) point.getSignature();
        Class<?> returnType = signature.getReturnType();
        return returnType;
    }

}
