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
import org.apache.commons.collections4.MapUtils;
import com.murong.prepayment.cache.to.CacheWrapper;
import com.murong.prepayment.common.util.LogUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 最近最少使用丢弃策略
 * @author lw.xu
 * @version $Id: LruCacheDiscard.java, v 0.1 2017年10月23日 下午11:22:35 lw.xu Exp $
 */
public class LruCacheDiscard implements CacheDiscard {

    private static final Logger logger = LoggerFactory.getLogger(LruCacheDiscard.class);

    @Override
    public void discard(MapCache mapCache) {

        if (mapCache == null || MapUtils.isEmpty(mapCache.getCache())) {
            return;
        }

        ConcurrentHashMap<String, Object> cache = mapCache.getCache();
        Iterator<Entry<String, Object>> iterator = cache.entrySet().iterator();

        //寻找lastAccessTime最小的对象
        String minAcsKey = null;
        CacheWrapper minAcsWrapper = new CacheWrapper(null);
        while (iterator.hasNext()) {
            Entry<String, Object> entry = iterator.next();
            String key = entry.getKey();
            Object obj = entry.getValue();
            if (obj instanceof CacheWrapper) {
                CacheWrapper wrapper = (CacheWrapper) obj;
                if (wrapper.getLastAccessTime() < minAcsWrapper.getLastAccessTime()) {
                    minAcsKey = key;
                    minAcsWrapper = wrapper;
                }
            }
        }

        //构造需要被删除的缓存CacheKey
        CacheKey delKey = new CacheKey(mapCache.getConfig().getNameSpace(), minAcsKey);

        mapCache.delete(delKey);

        LogUtil.info(logger, "LRU被删除对象key={0}", delKey);

    }

}
