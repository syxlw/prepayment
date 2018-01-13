/**
 * 深圳金融电子结算中心
 * Copyright (c) 1995-2018 All Rights Reserved.
 */
package com.murong.prepayment.web.mvc.service.impl;

import org.apache.rocketmq.client.producer.MessageQueueSelector;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageQueue;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 
 * @author lw.xu
 * @version $Id: UserRegisterQueueSelector.java, v 0.1 2018年1月11日 下午8:41:34 lw.xu Exp $
 */
@Service("userRegisterQueueSelector")
public class UserRegisterQueueSelector implements MessageQueueSelector {

    @Override
    public MessageQueue select(List<MessageQueue> mqs, Message msg, Object arg) {
        long userId = (long) arg;
        long index = userId % mqs.size();
        return mqs.get((int) index);
    }

}
