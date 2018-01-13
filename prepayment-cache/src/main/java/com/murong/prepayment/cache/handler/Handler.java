/**
 * 深圳金融电子结算中心
 * Copyright (c) 1995-2017 All Rights Reserved.
 */
package com.murong.prepayment.cache.handler;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * 缓存处理接口
 * @author lw.xu
 * @version $Id: Handler.java, v 0.1 2017年10月27日 上午10:52:31 lw.xu Exp $
 */
public interface Handler {

    /**
     * 处理缓存
     * @param jp 切面连接点
     * @return   执行结果
     */
    Object handleCacheable(ProceedingJoinPoint jp) throws Throwable;

    /**
     * 处理删除缓存
     * @param jp 切面连接点
     * @return   执行结果
     */
    Object handleCacheDel(ProceedingJoinPoint jp) throws Throwable;

}
