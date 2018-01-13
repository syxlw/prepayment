/**
 * 深圳金融电子结算中心
 * Copyright (c) 1995-2017 All Rights Reserved.
 */
package com.murong.prepayment.cache.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import com.murong.prepayment.cache.annotation.CacheDel;
import com.murong.prepayment.cache.handler.Handler;

/**
 * 拦截{@link CacheDel}注解
 * @author lw.xu
 * @version $Id: CacheDelAspect.java, v 0.1 2017年10月27日 上午11:07:58 lw.xu Exp $
 */
public class CacheDelAspect {

    private Handler handler;

    public CacheDelAspect(Handler handler) {
        this.handler = handler;
    }

    public Object around(ProceedingJoinPoint jp) throws Throwable {
        return handler.handleCacheDel(jp);
    }

}
