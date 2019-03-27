/**
 * Alipay.com Inc. Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.huke.demo.feign.service.impl;

import com.huke.demo.feign.http.invoker.UserInvoker;
import com.huke.demo.feign.service.UserService;
import com.huke.demo.feign.vo.FeignUserVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author huke
 * @version $Id: UserServiceImpl.java, v 0.1 2018年12月26日 16:29 huke Exp $
 */
@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserInvoker userInvoker;

    @Override
    public Boolean addUser(String name, Integer age) {
        FeignUserVO userVO = this.userInvoker.getUserById(12L);

        log.info("feign user1: {}", userVO.getName());
        log.info("add user1 {} {}", name, age);
        return true;
    }

    @Override
    public int countUser() {
        log.info("count user is 10 add");
        return 10;
    }
}
