/**
 * 深圳金融电子结算中心
 * Copyright (c) 1995-2017 All Rights Reserved.
 */
package com.murong.prepayment.cache.serializer;

import com.murong.prepayment.cache.exception.SerializationException;

/**
 * 序列化接口
 * @author lw.xu
 * @version $Id: Serializer.java, v 0.1 2017年10月18日 下午6:57:44 lw.xu Exp $
 */
public interface Serializer<T> {

    /**
     * 将制定对象序列化为二进制数据
     */
    byte[] serialize(T t) throws SerializationException;

    /**
     * 将二进制数据反序列化为对象
     */
    T deserialize(byte[] bytes) throws SerializationException;

}
