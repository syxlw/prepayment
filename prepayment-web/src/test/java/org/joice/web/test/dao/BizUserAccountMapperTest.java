/**
 * 深圳金融电子结算中心
 * Copyright (c) 1995-2018 All Rights Reserved.
 */
package org.prepayment.web.test.dao;

import javax.annotation.Resource;

import com.murong.prepayment.common.dao.BizUserAccountMapper;
import com.murong.prepayment.common.dao.domain.BizUserAccount;
import org.prepayment.web.test.base.BaseTest;
import org.junit.Assert;
import org.junit.Test;

/**
 * 
 * @author lw.xu
 * @version $Id: BizUserAccountMapperTest.java, v 0.1 2018年1月2日 下午4:51:40 lw.xu Exp $
 */
public class BizUserAccountMapperTest extends BaseTest {

    @Resource
    private BizUserAccountMapper bizUserAccountMapper;

    @Test
    public void testSelect() {
        Assert.assertNotNull(bizUserAccountMapper);

        int id = 2;
        BizUserAccount userAccount = bizUserAccountMapper.selectByPrimaryKey(id);

        Assert.assertNotNull(userAccount);
        Assert.assertTrue(userAccount.getId() == id);
    }

}
