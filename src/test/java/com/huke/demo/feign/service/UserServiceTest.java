/**
 * Alipay.com Inc. Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.huke.demo.feign.service;

import com.huke.demo.feign.http.invoker.UserInvoker;
import com.huke.demo.feign.service.impl.UserServiceImpl;
import com.huke.demo.feign.vo.FeignUserVO;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.when;

/**
 * @author huke 12
 * @version $Id: UserServiceTest.java, v 0.1 2018年12月26日 16:30 huke Exp $
 */
@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

    @InjectMocks
    private UserService userService = new UserServiceImpl();

    @Mock
    private UserInvoker userInvoker;

    @Mock
    private FeignUserVO feignUserVO;

    @Before
    public void before() {
        MockitoAnnotations.initMocks(this);
        when(this.feignUserVO.getName()).thenReturn("huke2 d dd");
        when(this.userInvoker.getUserById(anyLong())).thenReturn(this.feignUserVO);
    }

    @Test
    public void testAddUser() {
        boolean result = this.userService.addUser("123 4ddd", 13);
        Assert.assertTrue(result);
    }
}
