/**
 * 深圳金融电子结算中心
 * Copyright (c) 1995-2018 All Rights Reserved.
 */
package com.murong.prepayment.web.mvc.service;

import com.murong.prepayment.common.dto.PayOrderRequest;

/**
 * 订单服务接口
 * @author lw.xu
 * @version $Id: OrderService.java, v 0.1 2018年1月2日 下午7:32:28 lw.xu Exp $
 */
public interface OrderService {

    /**
     * 用户下单
     * @param orderRequest 订单请求对象
     * @return      true表示下单成功
     */
    boolean pay(PayOrderRequest orderRequest);

}
