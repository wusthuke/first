/**
 * Alipay.com Inc. Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.huke.demo.feign.service;

/**
 * @author huke
 * @version $Id: UserService.java, v 0.1 2018年12月26日 16:28 huke Exp $
 */
public interface UserService {

    Boolean addUser(String name, Integer age);

    int countUser();
}
