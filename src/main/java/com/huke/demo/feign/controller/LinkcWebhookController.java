/**
 * Alipay.com Inc. Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.huke.demo.feign.controller;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author huke
 * @version $Id: LinkcWebhookController.java, v 0.1 2019年02月18日 16:21 huke Exp $
 */
@RestController
@RequestMapping("hook")
@Slf4j
public class LinkcWebhookController {

    @PostMapping
    public void accept(@RequestHeader Map headers, @RequestBody Map body) {
        log.info("header: {}", JSON.toJSONString(headers));
        log.info("body: {}", JSON.toJSONString(body));
    }

    @PostMapping("/{test}")
    public void accept2(@PathVariable("test") String test, @RequestHeader Map headers, @RequestBody Map body) {
        log.info("hook2.....");
        log.info("header: {}", JSON.toJSONString(headers));
        log.info("body: {}", JSON.toJSONString(body));
    }
}
