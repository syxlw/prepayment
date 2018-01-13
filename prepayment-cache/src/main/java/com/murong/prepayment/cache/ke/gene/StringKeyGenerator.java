/**
 * 深圳金融电子结算中心
 * Copyright (c) 1995-2017 All Rights Reserved.
 */
package com.murong.prepayment.cache.ke.gene;

import java.lang.reflect.Method;

/**
 * 字符串Key生成器
 * @author lw.xu
 * @version $Id: StringKeyGenerator.java, v 0.1 2017年10月26日 上午11:08:48 lw.xu Exp $
 */
public class StringKeyGenerator implements KeyGenerator<String> {

    @Override
    public String getKey(Object target, Method method, Object... params) {
        return null;
    }

}
