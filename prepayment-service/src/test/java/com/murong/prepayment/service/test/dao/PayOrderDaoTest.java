/**
 * 深圳金融电子结算中心
 * Copyright (c) 1995-2017 All Rights Reserved.
 */
package com.murong.prepayment.service.test.dao;

import javax.annotation.Resource;

import com.murong.prepayment.common.dao.BizPayOrderMapper;
import com.murong.prepayment.common.dao.domain.BizPayOrder;
import com.murong.prepayment.common.enums.TradeSceneEnum;
import com.murong.prepayment.common.enums.TradeStatusEnmu;
import com.murong.prepayment.common.util.LogUtil;
import com.murong.prepayment.common.util.Money;
import com.murong.prepayment.service.test.BaseTest;
import org.junit.Assert;
import org.junit.Test;

import com.alibaba.druid.filter.config.ConfigTools;

/**
 * 测试BizPayOrderMapper
 * @author lw.xu
 * @version $Id: PayOrderDaoTest.java, v 0.1 2017年8月19日 下午4:54:59 lw.xu Exp $
 */
public class PayOrderDaoTest extends BaseTest {

    @Resource
    private BizPayOrderMapper bizPayOrderMapper;

    @Test
    public void testInsert() {
        BizPayOrder record = new BizPayOrder();

        record.setBuyerUserId("6");
        record.setMerchantId("006");
        record.setTradeNo("tradeNo" + geneRandomId());
        record.setTradeAmount(new Money(12.3));
        record.setTradeStatus(TradeStatusEnmu.trade_success.getCode());
        record.setScene(TradeSceneEnum.bar_code.getCode());
        record.setGoodsDetail("mate9 64G");

        int ret = bizPayOrderMapper.insert(record);

        Assert.assertTrue(ret == 1);
    }

    @Test
    public void testQueryById() {
        Long id = 3L;
        BizPayOrder order = bizPayOrderMapper.selectByPrimaryKey(id);
        LogUtil.info(logger, "order : {0}", order);
        Assert.assertNotNull(order);
        Assert.assertTrue(order.getId() == id);
    }

    @Test
    public void testEncrypt() throws Exception {
        String password = "lw.xu";
        String[] arr = ConfigTools.genKeyPair(512);
        LogUtil.info(logger, "password:{0}", ConfigTools.encrypt(password));
    }

}
