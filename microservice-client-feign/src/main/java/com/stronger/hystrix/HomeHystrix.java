package com.stronger.hystrix;

import com.stronger.service.HomeService;
import feign.Param;
import org.springframework.stereotype.Component;

/**
 * Created by wuqiang on 2017/11/10-0010.
 */
@Component
public class HomeHystrix implements HomeService{
    @Override
    public String hello(@Param(value = "name") String name) {
        return null;
    }
}
