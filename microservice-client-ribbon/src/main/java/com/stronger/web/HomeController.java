package com.stronger.web;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * ribbon + restTemplate
 * Created by wuqiang on 2017/11/10-0010.
 */
@RestController
@RequestMapping(value = "/home/")
public class HomeController {

    Logger log = LoggerFactory.getLogger(HomeController.class);

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping(value = "ribbonHello")
    @HystrixCommand(fallbackMethod = "ribbonHelloHystrix") //熔断器
    public String ribbonHello(String name){
        log.info("************执行 ribbonHello方法********* 入参[name]:"+name);
        return restTemplate.getForObject("http://cilent/home/hello?userName="+name,String.class);
    }

    /**
     * 异常处理方法
     * @param name
     * @return
     */
    public String ribbonHelloHystrix(String name){
        log.info("*************请求 ribbonHello 方法失败 执行熔断方法");
        return "sorry !!! this is ribbon hystrix!";
    }


}
