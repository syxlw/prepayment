/**
 * 深圳金融电子结算中心
 * Copyright (c) 1995-2018 All Rights Reserved.
 */
package com.murong.prepayment.web.mvc.service.impl;

import com.alibaba.fastjson.JSON;
import com.murong.prepayment.common.dto.PayOrderRequest;
import com.murong.prepayment.common.util.LogUtil;
import com.murong.prepayment.web.mvc.service.OrderCreationMqProducerService;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.*;
import org.apache.rocketmq.common.message.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;

/**
 * 创建订单消息生产者接口实现类
 * <p>向joice-service工程发送事务消息创建订单</p>
 * @author lw.xu
 * @version $Id: OrderCreationMqProducerServiceImpl.java, v 0.1 2018年1月3日 上午10:43:42 lw.xu Exp $
 */
public class OrderCreationMqProducerServiceImpl implements OrderCreationMqProducerService {

    private static final Logger      logger = LoggerFactory.getLogger(OrderCreationMqProducerServiceImpl.class);

    /** 事务消息生产者 */
    private TransactionMQProducer    txMQProducer;

    /** 事务回查监听器 */
    @Resource(name = "accountTxCheckListener")
    private TransactionCheckListener checkListener;

    /** 本地事务执行器 */
    @Resource(name = "accountUpdateTxExecuter")
    private LocalTransactionExecuter localTxExecuter;

    private String                   namesrvAddr;

    private String                   txProducerGroup;

    private String                   topic;

    private String                   tag;

    public void init() throws MQClientException {
        LogUtil.info(logger, "prepayment-web order creation txMQProducer init, namesrvAddr:{0}, txProducerGroup:{1}", namesrvAddr, txProducerGroup);

        txMQProducer = new TransactionMQProducer(txProducerGroup);
        txMQProducer.setNamesrvAddr(namesrvAddr);
        txMQProducer.setInstanceName(String.valueOf(System.currentTimeMillis()));
        txMQProducer.setTransactionCheckListener(checkListener);

        txMQProducer.start();

        LogUtil.info(logger, "prepayment-web order creation txMQProducer init successful!");
    }

    @Override
    public boolean process(PayOrderRequest orderRequest) throws MQClientException {
        LogUtil.info(logger, "收到发送创建订单消息请求,orderRequest={0}", orderRequest);

        Message msg = createMessage(orderRequest);
        TransactionSendResult sendRet = txMQProducer.sendMessageInTransaction(msg, localTxExecuter, orderRequest);

        LogUtil.info(logger, "事务消息发送完成,sendRet={0}", sendRet);

        return sendRet.getSendStatus() == SendStatus.SEND_OK ? true : false;

    }

    public void destory() {
        txMQProducer.shutdown();
        LogUtil.info(logger, "prepayment-web order creation txMQProducer shutdown successful!");
    }

    private Message createMessage(PayOrderRequest orderRequest) {
        String orderJson = JSON.toJSONString(orderRequest);
        String key = String.valueOf(System.currentTimeMillis());
        Message msg = new Message(topic, tag, key, orderJson.getBytes());

        return msg;
    }

    public String getNamesrvAddr() {
        return namesrvAddr;
    }

    public void setNamesrvAddr(String namesrvAddr) {
        this.namesrvAddr = namesrvAddr;
    }

    public String getTxProducerGroup() {
        return txProducerGroup;
    }

    public void setTxProducerGroup(String txProducerGroup) {
        this.txProducerGroup = txProducerGroup;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

}
