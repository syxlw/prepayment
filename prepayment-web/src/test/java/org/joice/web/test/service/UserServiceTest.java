/**
 * 深圳金融电子结算中心
 * Copyright (c) 1995-2018 All Rights Reserved.
 */
package org.prepayment.web.test.service;

import javax.annotation.Resource;

import com.murong.prepayment.web.mvc.service.UserService;
import org.prepayment.web.test.base.BaseTest;
import org.junit.Assert;
import org.junit.Test;

/**
 * 
 * @author lw.xu
 * @version $Id: UserServiceTest.java, v 0.1 2018年1月12日 上午11:02:25 lw.xu Exp $
 */
public class UserServiceTest extends BaseTest {

    @Resource
    private UserService userService;

    @Test
    public void testUserRegister() {

        Assert.assertNotNull(userService);

        int loopCnt = 100;
        for (int i = 0; i < loopCnt; i++) {
            String userName = "userName" + System.currentTimeMillis();
            userService.register(userName);
        }

    }
}
