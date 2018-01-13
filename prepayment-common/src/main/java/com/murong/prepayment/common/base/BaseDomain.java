/**
 * 深圳金融电子结算中心
 * Copyright (c) 1896-2016 All Rights Reserved.
 */
package com.murong.prepayment.common.base;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;

/**
 * 实体的基础类
 * @author lw.xu
 * @version $Id: BaseDomain.java, v 0.1 2016年9月11日 下午1:18:52 lw.xu Exp $
 */
public class BaseDomain implements Serializable {

    /**  */
    private static final long serialVersionUID = -5001284489454315434L;

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

}
