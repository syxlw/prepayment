/**
 * 深圳金融电子结算中心
 * Copyright (c) 1995-2018 All Rights Reserved.
 */
package com.murong.prepayment.web.mvc.service.impl;

import com.murong.prepayment.common.constant.Constants;
import com.murong.prepayment.common.dao.BizUserAccountMapper;
import com.murong.prepayment.common.dto.PayOrderRequest;
import com.murong.prepayment.common.util.LogUtil;
import com.murong.prepayment.common.util.Money;
import org.apache.rocketmq.client.producer.LocalTransactionExecuter;
import org.apache.rocketmq.client.producer.LocalTransactionState;
import org.apache.rocketmq.common.message.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * 账户修改事务执行器
 * 该事务执行器执行本地事务
 * @author lw.xu
 * @version $Id: AccountUpdateTxExecuter.java, v 0.1 2018年1月3日 上午11:15:05 lw.xu Exp $
 */
@Service("accountUpdateTxExecuter")
public class AccountUpdateTxExecuter implements LocalTransactionExecuter {

    private static final Logger  logger = LoggerFactory.getLogger(AccountUpdateTxExecuter.class);

    @Resource
    private BizUserAccountMapper bizUserAccountMapper;

    @Override
    public LocalTransactionState executeLocalTransactionBranch(Message msg, Object arg) {

        LogUtil.info(logger, "收到执行本地账户修改事务请求");

        PayOrderRequest order = (PayOrderRequest) arg;

        int ret = bizUserAccountMapper.updateBalance(assembleParaMap(order));

        if (ret == 1) {
            LogUtil.info(logger, "本地账户修改事务执行成功,order={0}", order);

            msg.putUserProperty(Constants.IS_LOCAL_TX_SUCCESS, Constants.TX_SUCCESS);
            return LocalTransactionState.COMMIT_MESSAGE;
        }

        return LocalTransactionState.ROLLBACK_MESSAGE;
    }

    /**
     * 组装参数Map
     */
    private Map<String, Object> assembleParaMap(PayOrderRequest order) {
        Map<String, Object> paraMap = new HashMap<String, Object>();

        Money tradeAmount = new Money(order.getTradeAmount());

        //金额转化为负数，表示扣款
        paraMap.put(Constants.MODIDIED_BALANCE, -tradeAmount.getCent());
        paraMap.put(Constants.USER_ID, order.getBuyerUserId());

        return paraMap;
    }
}
