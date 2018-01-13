/**
 * 深圳金融电子结算中心
 * Copyright (c) 1995-2017 All Rights Reserved.
 */
package com.murong.prepayment.web.mvc.controller;

import com.murong.prepayment.common.util.LogUtil;
import com.murong.prepayment.facade.api.MqProducerFacade;
import org.apache.rocketmq.common.message.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * MQ Controller
 * @author lw.xu
 * @version $Id: MqController.java, v 0.1 2017年9月6日 上午11:32:58 lw.xu Exp $
 */
@RestController
public class MqController {

    private static final Logger logger = LoggerFactory.getLogger(MqController.class);

    @Resource
    private MqProducerFacade    mqProducerFacade;

    @GetMapping("mq/produce")
    public String produce(ModelMap modelMap) throws Exception {
        LogUtil.info(logger, "收到发送message请求");
        Message msg = createMessage();
        String sendResult = mqProducerFacade.send(msg);
        LogUtil.info(logger, "message sendResult:{0}", sendResult);

        return sendResult;
    }

    @GetMapping("mq/produceMsgs")
    public String produceMsgs(ModelMap modelMap) throws Exception {
        LogUtil.info(logger, "收到批量发送message请求");
        for (int i = 0; i < 1000; i++) {
            Message msg = createMessage(i);
            String sendResult = mqProducerFacade.send(msg);
            LogUtil.info(logger, "message sendResult:{0}", sendResult);
        }

        return "批量发送完成";
    }

    @GetMapping("mq/txProduce")
    public String txProduce(ModelMap modelMap) throws Exception {
        LogUtil.info(logger, "收到发送tx message请求");
        Message msg = createMessage();
        String sendResult = mqProducerFacade.sendInTx(msg);
        LogUtil.info(logger, "txMessage sendResult:{0}", sendResult);

        return sendResult;
    }

    @GetMapping("mq/orderProduce")
    public String orderProduce(ModelMap modelMap) throws Exception {
        LogUtil.info(logger, "收到顺序发送message请求");
        for (int i = 0; i < 1000; i++) {
            int orderId = i % 10;
            Message msg = createMessage(i);
            String sendResult = mqProducerFacade.sendInOrder(msg, orderId);
            LogUtil.info(logger, "orderMessage sendResult:{0}", sendResult);
        }

        return "顺序消息发送完成";
    }

    private Message createMessage() {
        String topic = "prepayment-ms";
        String tag = "orderMsg";
        String key = String.valueOf(System.currentTimeMillis());
        String content = "这个一条测试订单消息" + key;

        Message msg = new Message(topic, tag, key, content.getBytes());

        return msg;
    }

    private Message createMessage(int id) {
        String topic = "prepayment-ms";
        String tag = "orderMsg";
        String key = String.valueOf(System.currentTimeMillis());
        String content = "这个一条测试订单消息" + id;

        Message msg = new Message(topic, tag, key, content.getBytes());

        return msg;
    }

}
