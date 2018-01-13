/**
 * 深圳金融电子结算中心
 * Copyright (c) 1995-2017 All Rights Reserved.
 */
package com.murong.prepayment.cache.map;

import com.murong.prepayment.cache.discard.CacheDiscard;
import com.murong.prepayment.cache.discard.CacheDiscardFactory;
import com.murong.prepayment.cache.enums.CacheDiscardPolicyEnum;
import com.murong.prepayment.cache.config.CacheConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 监听Map Cache的变化
 * @author lw.xu
 * @version $Id: MapCacheChangeListener.java, v 0.1 2017年10月23日 下午5:01:09 lw.xu Exp $
 */
public class MapCacheChangeListener {

    private static final Logger          logger  = LoggerFactory.getLogger(MapCacheChangeListener.class);

    private final MapCache               cache;

    private final CacheDiscardPolicyEnum policyEnum;

    private final CacheDiscardFactory factory = CacheDiscardFactory.getInstance();

    public MapCacheChangeListener(CacheConfig config, MapCache cache) {
        this.cache = cache;
        this.policyEnum = CacheDiscardPolicyEnum.valueOf(config.getDiscardPolicy().toUpperCase());
    }

    /**
     * 根据策略丢弃缓存
     */
    public void discard() {
        CacheDiscard cacheDiscard = factory.getCacheDiscard(policyEnum);
        cacheDiscard.discard(cache);
    }

}
