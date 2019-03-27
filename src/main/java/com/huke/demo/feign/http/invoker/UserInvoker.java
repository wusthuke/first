/**
 * Alipay.com Inc. Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.huke.demo.feign.http.invoker;

import com.huke.demo.feign.vo.FeignUserVO;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author huke ab
 * @version $Id: UserInvoker.java, v 0.1 2018年12月11日 15:02 huke Exp $
 */
@FeignClient(name = "userInvoker", url = "http://localhost:8080/users")
public interface UserInvoker extends BasicInvoker {

    @RequestMapping(method = RequestMethod.GET, value = "{id}")
    FeignUserVO getUserById(@PathVariable("id") Long id);

    @RequestMapping(method = RequestMethod.GET, value = "{id}/not")
    FeignUserVO getUserByIdNotExist(@PathVariable("id") Long id);

    @RequestMapping(method = RequestMethod.GET, value = "{id}/timeout")
    FeignUserVO getUserByIdTimeOut(@PathVariable("id") Long id);

}
