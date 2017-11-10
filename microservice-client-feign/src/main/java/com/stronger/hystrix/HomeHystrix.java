package com.stronger.hystrix;

import com.stronger.service.HomeService;
import feign.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Created by wuqiang on 2017/11/10-0010.
 */
@Component
public class HomeHystrix implements HomeService{

    Logger log = LoggerFactory.getLogger(HomeHystrix.class);

    @Override
    public String hello(@Param(value = "name") String name) {
        log.info("*************feign 请求hello 失败  进入熔断***********");
        return "sorry! ! ! this is feign hystrix!";
    }
}
