/**
 * 深圳金融电子结算中心
 * Copyright (c) 1995-2017 All Rights Reserved.
 */
package com.murong.prepayment.cache.test;

import com.murong.prepayment.cache.test.domain.Department;
import com.murong.prepayment.cache.config.CacheConfig;
import com.murong.prepayment.cache.map.MapCache;
import com.murong.prepayment.cache.test.domain.Employee;
import com.murong.prepayment.cache.to.CacheKey;
import com.murong.prepayment.cache.to.CacheWrapper;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * 测试{@link MapCache}
 * @author lw.xu
 * @version $Id: MapCacheTest.java, v 0.1 2017年10月19日 下午6:37:21 lw.xu Exp $
 */
public class MapCacheTest {

    private CacheConfig cacheConfig = new CacheConfig();

    private MapCache    cache;

    private Department dept        = new Department(11L, "陆军");

    private Employee    emp         = new Employee(1L, "林冲", dept);

    @Before
    public void init() {
        cache = new MapCache(cacheConfig);
    }

    @Test
    public void testSetAndGet() throws Exception {
        Assert.assertNotNull(cache);
        CacheKey cacheKey = new CacheKey(emp.getId() + "");
        int expire = 5;

        CacheWrapper wrapper = new CacheWrapper(emp, expire);

        //测试普通set
        cache.set(cacheKey, wrapper);
        CacheWrapper ret = cache.get(cacheKey);
        Assert.assertNotNull(ret);
        Assert.assertTrue(((Employee) (ret.getObj())).getId() == emp.getId());

        //测试超时
        Thread.sleep(expire * 1000 + 200);//休眠时间略大于expire time

        ret = cache.get(cacheKey);
        Assert.assertNull(ret);

    }

    @Test
    public void testDelete() {
        Assert.assertNotNull(cache);
        CacheKey cacheKey = new CacheKey(emp.getId() + "");

        CacheWrapper wrapper = new CacheWrapper(emp);

        cache.set(cacheKey, wrapper);

        //删除之前缓存还有数据 
        CacheWrapper ret = cache.get(cacheKey);
        Assert.assertNotNull(ret);

        //删除之后缓存没有数据
        long delCnt = cache.delete(cacheKey);
        Assert.assertTrue(delCnt == 1);

        ret = cache.get(cacheKey);
        Assert.assertTrue(ret == null);
    }

    @After
    public void shutdown() {
        cache.shutdown();
    }

}
