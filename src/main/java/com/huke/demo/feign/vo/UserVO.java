/**
 * Alipay.com Inc. Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.huke.demo.feign.vo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author huke
 * @version $Id: UserVO.java, v 0.1 2018年12月11日 14:43 huke Exp $
 */
@Getter
@Setter
public class UserVO implements Serializable {

    private static final long serialVersionUID = 4711304609026388600L;

    private Long id;

    private String name;

    private Integer age;
}