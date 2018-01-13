/**
 * 深圳金融电子结算中心
 * Copyright (c) 1995-2017 All Rights Reserved.
 */
package com.murong.prepayment.cache.discard;

import com.murong.prepayment.cache.map.MapCache;

/**
 * 缓存丢弃接口
 * @author lw.xu
 * @version $Id: CacheDiscard.java, v 0.1 2017年10月23日 下午8:58:09 lw.xu Exp $
 */
public interface CacheDiscard {

    /**
     * 丢弃缓存方法
     * @param mapCache
     */
    void discard(MapCache mapCache);

}
