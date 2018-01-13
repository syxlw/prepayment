/**
 * 深圳金融电子结算中心
 * Copyright (c) 1995-2017 All Rights Reserved.
 */
package com.murong.prepayment.facade.api;

import org.apache.rocketmq.common.message.Message;

/**
 * MQ门面
 * @author lw.xu
 * @version $Id: MqProducerFacade.java, v 0.1 2017年9月6日 上午11:25:13 lw.xu Exp $
 */
public interface MqProducerFacade {

    /**
     * 发送普通Message
     */
    String send(Message message) throws Exception;

    /**
     * 发送事务消息
     */
    String sendInTx(Message message) throws Exception;

    /**
     * 发送顺序消息
     */
    String sendInOrder(Message message, int orderId) throws Exception;

    /**
     * 关闭producer
     */
    void shutdown();

}
