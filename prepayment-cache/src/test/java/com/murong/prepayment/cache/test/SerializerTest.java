/**
 * 深圳金融电子结算中心
 * Copyright (c) 1995-2017 All Rights Reserved.
 */
package com.murong.prepayment.cache.test;

import com.murong.prepayment.cache.serializer.HessianSerializer;
import com.murong.prepayment.cache.serializer.Serializer;
import com.murong.prepayment.cache.serializer.StringSerializer;
import com.murong.prepayment.cache.test.domain.Department;
import org.apache.commons.lang3.StringUtils;
import com.murong.prepayment.cache.test.domain.Employee;
import org.junit.Assert;
import org.junit.Test;

/**
 * 测试StringSerializer
 * @author lw.xu
 * @version $Id: SerializerTest.java, v 0.1 2017年10月18日 下午7:50:04 lw.xu Exp $
 */
public class SerializerTest {

    private String               str               = "This is a String Serializer Test";

    private Serializer<String> stringSerializer  = new StringSerializer();

    private Department dept              = new Department(1L, "技术部");

    private Employee             employee          = new Employee(2L, "宋江", dept);

    private Serializer<Employee> hessianSerializer = new HessianSerializer<Employee>();

    @Test
    public void testStringSerializer() {
        byte[] ret = stringSerializer.serialize(str);
        Assert.assertTrue(ret != null);
        Assert.assertTrue(ret.length > 0);

        String deRet = stringSerializer.deserialize(ret);
        Assert.assertTrue(StringUtils.isNotBlank(deRet));
        Assert.assertTrue(StringUtils.equals(deRet, str));
    }

    @Test
    public void testHessianSerializer() {
        byte[] ret = hessianSerializer.serialize(employee);
        Assert.assertTrue(ret != null);
        Assert.assertTrue(ret.length > 0);

        Employee deEmp = hessianSerializer.deserialize(ret);
        Assert.assertTrue(deEmp != null);
        Assert.assertTrue(employee.getId() == deEmp.getId());
    }

    @Test
    public void testHessianSerializerNull() {
        byte[] ret = hessianSerializer.serialize(null);
        Assert.assertTrue(ret == null);

        Employee deRet = hessianSerializer.deserialize(null);
        Assert.assertTrue(deRet == null);
    }

}
