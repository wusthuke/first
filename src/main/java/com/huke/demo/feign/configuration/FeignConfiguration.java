/**
 * Alipay.com Inc. Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.huke.demo.feign.configuration;

import feign.*;
import feign.codec.ErrorDecoder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

/**
 * @author huke
 * @version $Id: FeignConfiguration.java, v 0.1 2018年12月11日 20:55 huke Exp $
 */
@Configuration
public class FeignConfiguration {

    public static int connectTimeOutMillis = 1000;
    public static int readTimeOutMillis    = 1000;

    @Bean
    public Request.Options options() {
        return new Request.Options(connectTimeOutMillis, readTimeOutMillis);
    }

    @Bean
    public Retryer retryer() {
        return new Retryer() {
            @Override
            public void continueOrPropagate(RetryableException e) {
                if (e.getCause() instanceof IOException) {
                    throw new RuntimeException("调用异常: " + e.getCause().getMessage());
                }
                throw e;
            }

            @Override
            public Retryer clone() {
                return this;
            }
        };
    }

    @Bean
    public ErrorDecoder errorDecoder() {
        return new UserErrorDecoder();
    }

    @Slf4j
    public static class UserErrorDecoder implements ErrorDecoder {
        @Override
        public Exception decode(String methodKey, Response response) {
            Exception exception = null;
            try {
                // 获取原始的返回内容
                String json = Util.toString(response.body().asReader());
                log.warn(json);
                exception = new RuntimeException("调用异常 2");
            } catch (IOException ex) {
                log.error(ex.getMessage(), ex);
            }
            return exception;
        }
    }
}
