/**
 * 深圳金融电子结算中心
 * Copyright (c) 1995-2017 All Rights Reserved.
 */
package com.murong.prepayment.cache.aspect;

import com.murong.prepayment.cache.annotation.Cacheable;
import com.murong.prepayment.cache.handler.Handler;
import org.aspectj.lang.ProceedingJoinPoint;

/**
 * 拦截{@link Cacheable}注解
 * @author lw.xu
 * @version $Id: CacheAspect.java, v 0.1 2017年10月24日 下午7:56:48 lw.xu Exp $
 */
public class CacheableAspect {

    private Handler handler;

    public CacheableAspect(Handler handler) {
        this.handler = handler;
    }

    public Object around(ProceedingJoinPoint jp) throws Throwable {
        return handler.handleCacheable(jp);
    }
}
