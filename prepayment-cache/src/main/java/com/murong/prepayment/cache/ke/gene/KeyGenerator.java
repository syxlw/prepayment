/**
 * 深圳金融电子结算中心
 * Copyright (c) 1995-2017 All Rights Reserved.
 */
package com.murong.prepayment.cache.ke.gene;

import java.lang.reflect.Method;

/**
 * Key生成器接口
 * @author lw.xu
 * @version $Id: KeyGenerator.java, v 0.1 2017年10月26日 上午12:26:29 lw.xu Exp $
 */
public interface KeyGenerator<T> {

    /**
     * 获取key
     * @param obj
     * @return
     */
    T getKey(Object target, Method method, Object... params);

}
