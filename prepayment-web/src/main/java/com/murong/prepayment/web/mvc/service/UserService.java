/**
 * 深圳金融电子结算中心
 * Copyright (c) 1995-2018 All Rights Reserved.
 */
package com.murong.prepayment.web.mvc.service;

/**
 * 用户服务接口
 * @author lw.xu
 * @version $Id: UserService.java, v 0.1 2018年1月11日 下午7:24:53 lw.xu Exp $
 */
public interface UserService {

    /**
     * 用户注册
     * @param name 用户名
     */
    boolean register(String name);

}
