/**
 * 深圳金融电子结算中心
 * Copyright (c) 1995-2017 All Rights Reserved.
 */
package com.murong.prepayment.service.test.mq;

import javax.annotation.Resource;

import com.murong.prepayment.service.rocketmq.RocketMqProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import com.murong.prepayment.common.util.LogUtil;
import com.murong.prepayment.service.test.BaseTest;
import org.junit.Test;

/**
 * 测试RocketMQ
 * @author lw.xu
 * @version $Id: RocketMqTest.java, v 0.1 2017年9月6日 上午10:51:24 lw.xu Exp $
 */
public class RocketMqTest extends BaseTest {

    @Resource
    private RocketMqProducer rocketMqProducer;

    @Test
    public void testPush() throws Exception {
        String topic = "prepayment-ms";
        String tag = "orderMsg";
        String content = "这个一条测试订单消息";

        Message msg = new Message(topic, tag, String.valueOf(System.currentTimeMillis()), content.getBytes());
        SendResult sendResult = rocketMqProducer.getDefaultMQProducer().send(msg);

        LogUtil.info(logger, "id:{0}, sendStatus{1}", sendResult.getMsgId(), sendResult.getSendStatus());

        Thread.sleep(4000);
    }
}
