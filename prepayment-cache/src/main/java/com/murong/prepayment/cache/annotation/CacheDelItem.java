/**
 * 深圳金融电子结算中心
 * Copyright (c) 1995-2017 All Rights Reserved.
 */
package com.murong.prepayment.cache.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 缓存删除注解
 * 一个CacheDelItem表示一个要删除的缓存
 * @author lw.xu
 * @version $Id: CacheDelItem.java, v 0.1 2017年10月27日 上午10:31:18 lw.xu Exp $
 */
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface CacheDelItem {

    /**
     * 要删除的缓存key,支持Spring EL表达式
     */
    String key();

}
