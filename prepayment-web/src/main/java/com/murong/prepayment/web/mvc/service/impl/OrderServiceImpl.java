/**
 * 深圳金融电子结算中心
 * Copyright (c) 1995-2018 All Rights Reserved.
 */
package com.murong.prepayment.web.mvc.service.impl;

import com.murong.prepayment.common.dao.BizUserAccountMapper;
import com.murong.prepayment.common.dao.domain.BizUserAccount;
import com.murong.prepayment.common.dto.PayOrderRequest;
import com.murong.prepayment.common.util.AssertUtil;
import com.murong.prepayment.common.util.LogUtil;
import com.murong.prepayment.web.mvc.service.OrderCreationMqProducerService;
import com.murong.prepayment.web.mvc.service.OrderService;
import org.apache.rocketmq.client.exception.MQClientException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 订单服务接口实现类，用户下单分为两步：
 * <ul>
 *  <li>第一步：扣减用户余额</li>
 *  <li>第二步：插入订单记录</li>
 * </ul>
 * <p>第一步操作由本地执行，第二步由joice-service系统执行。这两步操作必须是同一个事务，
 * 但由于这两个操作分别在两个子系统中完成，此处使用事务消息实现</p>
 * @author lw.xu
 * @version $Id: OrderServiceImpl.java, v 0.1 2018年1月2日 下午7:32:45 lw.xu Exp $
 */
@Service
public class OrderServiceImpl implements OrderService {

    private static final Logger            logger = LoggerFactory.getLogger(OrderServiceImpl.class);

    @Resource
    private BizUserAccountMapper           bizUserAccountMapper;

    @Resource
    private OrderCreationMqProducerService orderCreationMqProducerService;

    @Override
    public boolean pay(PayOrderRequest orderRequest) {

        LogUtil.info(logger, "收到支付请求,userId={0},amount={1}", orderRequest.getBuyerUserId(), orderRequest.getTradeAmount());

        //1.查询账户
        BizUserAccount userAccount = bizUserAccountMapper.selectByUserId(orderRequest.getBuyerUserId());
        AssertUtil.assertNotNull(userAccount, "查询账户为空");

        //2.发送事务消息创建订单
        try {
            return orderCreationMqProducerService.process(orderRequest);
        } catch (MQClientException e) {
            throw new RuntimeException("事务消息发送失败", e);
        }
    }

}
