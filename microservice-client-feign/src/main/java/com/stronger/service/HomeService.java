package com.stronger.service;

import com.stronger.hystrix.HomeHystrix;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by wuqiang on 2017/11/10-0010.
 */
@FeignClient(value = "client" ,fallback = HomeHystrix.class)
public interface HomeService {
    @RequestMapping(value = "/home/hello")
    public String hello(@RequestParam(value="name") String name);
}
