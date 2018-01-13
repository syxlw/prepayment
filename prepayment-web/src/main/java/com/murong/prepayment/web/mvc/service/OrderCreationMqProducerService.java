/**
 * 深圳金融电子结算中心
 * Copyright (c) 1995-2018 All Rights Reserved.
 */
package com.murong.prepayment.web.mvc.service;

import org.apache.rocketmq.client.exception.MQClientException;
import com.murong.prepayment.common.dto.PayOrderRequest;

/**
 * 创建订单消息生产者接口
 * @author lw.xu
 * @version $Id: OrderCreationMqProducerService.java, v 0.1 2018年1月3日 上午10:41:23 lw.xu Exp $
 */
public interface OrderCreationMqProducerService {

    /**
     * 发送消息
     * @param orderRequest  订单实体对象
     * @throws MQClientException 
     * @return true表示发送成功
     */
    boolean process(PayOrderRequest orderRequest) throws MQClientException;

}
