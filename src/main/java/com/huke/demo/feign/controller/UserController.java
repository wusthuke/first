/**
 * Alipay.com Inc. Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.huke.demo.feign.controller;

import com.huke.demo.feign.vo.UserVO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @author huke
 * @version $Id: UserController.java, v 0.1 2018年12月11日 14:42 huke Exp $
 */
@RestController
@RequestMapping("users")
public class UserController {

    @GetMapping("{id}")
    public UserVO getById(@PathVariable("id") Long id) {
        UserVO userVO = new UserVO();
        userVO.setId(id);
        userVO.setAge(30);
        userVO.setName("test1234");
        return userVO;
    }

    @GetMapping("{id}/timeout")
    public UserVO getByIdForTimeOut(@PathVariable("id") Long id) {
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (Exception e) {
            // System.out.println("UserController sleep 2 seconds");
        }
        UserVO userVO = new UserVO();
        userVO.setId(id);
        return userVO;
    }
}
