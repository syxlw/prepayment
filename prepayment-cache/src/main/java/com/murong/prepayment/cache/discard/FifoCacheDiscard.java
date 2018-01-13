/**
 * 深圳金融电子结算中心
 * Copyright (c) 1995-2017 All Rights Reserved.
 */
package com.murong.prepayment.cache.discard;

import java.util.Iterator;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

import com.murong.prepayment.cache.map.MapCache;
import com.murong.prepayment.cache.to.CacheKey;
import com.murong.prepayment.cache.to.CacheWrapper;
import org.apache.commons.collections4.MapUtils;
import com.murong.prepayment.common.util.LogUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * FIFO缓存丢弃策略
 * @author lw.xu
 * @version $Id: FifoCacheDiscard.java, v 0.1 2017年10月23日 下午9:12:27 lw.xu Exp $
 */
public class FifoCacheDiscard implements CacheDiscard {

    private static final Logger logger = LoggerFactory.getLogger(FifoCacheDiscard.class);

    @Override
    public void discard(MapCache mapCache) {

        if (mapCache == null || MapUtils.isEmpty(mapCache.getCache())) {
            return;
        }

        ConcurrentHashMap<String, Object> cache = mapCache.getCache();
        Iterator<Entry<String, Object>> iterator = cache.entrySet().iterator();

        //寻找最早被缓存的对象
        String earlistKey = null;
        CacheWrapper earlistWrapper = new CacheWrapper(null);
        while (iterator.hasNext()) {
            Entry<String, Object> entry = iterator.next();
            String key = entry.getKey();
            Object obj = entry.getValue();
            if (obj instanceof CacheWrapper) {
                CacheWrapper wrapper = (CacheWrapper) obj;
                if (wrapper.getCreateTime() < earlistWrapper.getCreateTime()) {
                    earlistKey = key;
                    earlistWrapper = wrapper;
                }
            }
        }

        //构造需要被删除的缓存CacheKey
        CacheKey delKey = new CacheKey(mapCache.getConfig().getNameSpace(), earlistKey);

        mapCache.delete(delKey);

        LogUtil.info(logger, "FIFO被删除对象key={0}", delKey);

    }
}
