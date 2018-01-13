/**
 * 深圳金融电子结算中心
 * Copyright (c) 1995-2017 All Rights Reserved.
 */
package com.murong.prepayment.service.busi;

import com.murong.prepayment.common.dao.domain.BizPayOrder;

/**
 * 订单服务类
 * @author lw.xu
 * @version $Id: PayOrderService.java, v 0.1 2017年10月25日 下午12:44:01 lw.xu Exp $
 */
public interface PayOrderService {

    /**
     * 根据订单id获取订单对象
     * @param id
     * @return
     */
    BizPayOrder getById(Long id);

    /**
     * 查询订单对象
     * @param order
     * @return
     */
    BizPayOrder getById(BizPayOrder order);

    /**
     * 修改订单对象
     */
    boolean updateOrder(BizPayOrder order);

    /**
     * 插入订单
     */
    int insert(BizPayOrder order);

}
