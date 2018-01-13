/**
 * 深圳金融电子结算中心
 * Copyright (c) 1995-2017 All Rights Reserved.
 */
package com.murong.prepayment.cache.test.domain;

import com.murong.prepayment.cache.to.BaseTO;

/**
 * 
 * @author lw.xu
 * @version $Id: Department.java, v 0.1 2017年10月10日 下午5:01:53 lw.xu Exp $
 */
public class Department extends BaseTO {

    /**  */
    private static final long serialVersionUID = -1147152502153578013L;

    private long              deptId;

    private String            name;

    public Department(long deptId, String name) {
        this.deptId = deptId;
        this.name = name;
    }

    public long getDeptId() {
        return deptId;
    }

    public void setDeptId(long deptId) {
        this.deptId = deptId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
