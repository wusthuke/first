/**
 * Alipay.com Inc. Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.huke.demo.feign.controller;

import com.huke.demo.feign.http.invoker.UserInvoker;
import com.huke.demo.feign.vo.FeignUserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author huked23
 * @version $Id: FeginController.java, v 0.1 2018年12月11日 14:59 huke Exp $
 */
@RestController
@RequestMapping("feign")
public class FeignController {

    @Autowired
    private UserInvoker userInvoker;

    @GetMapping("{id}")
    public FeignUserVO getUserById(@PathVariable("id") Long id) {
        return this.userInvoker.getUserById(id);
    }

    @GetMapping("{id}/not")
    public FeignUserVO getUserByIdNotExist(@PathVariable("id") Long id) {
        return this.userInvoker.getUserByIdNotExist(id);
    }


    @GetMapping("{id}/timeout")
    public FeignUserVO getUserByIdTimeOut(@PathVariable("id") Long id) {
        return this.userInvoker.getUserByIdTimeOut(id);
    }
}
