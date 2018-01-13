/**
 * 深圳金融电子结算中心
 * Copyright (c) 1995-2017 All Rights Reserved.
 */
package com.murong.prepayment.cache.enums;

/**
 * 缓存丢弃策略
 * @author lw.xu
 * @version $Id: CacheDiscardPolicyEnum.java, v 0.1 2017年10月23日 下午5:22:51 lw.xu Exp $
 */
public enum CacheDiscardPolicyEnum {

    FIFO, //先进先出 
    LRU; //最近最少使用

}
