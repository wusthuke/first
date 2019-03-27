/**
 * Alipay.com Inc. Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.huke.demo.feign.vo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author huke
 * @version $Id: FeignUserVO.java, v 0.1 2018年12月11日 15:00 huke Exp $
 */
@Getter
@Setter
public class FeignUserVO implements Serializable {

    private static final long serialVersionUID = 5471962093751048291L;

    private Long id;

    private String name;

    private Integer age;
}