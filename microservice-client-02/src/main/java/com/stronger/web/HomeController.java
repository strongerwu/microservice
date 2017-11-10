package com.stronger.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by wuqiang on 2017/11/10-0010.
 */
@RestController
@RequestMapping(value = "/home/")
public class HomeController {

    private Logger log = LoggerFactory.getLogger(HomeController.class);

    @Value("${server.port}")
    String port;

    @RequestMapping(value="hello")
    public String hello(String name){
        log.info("*******进入home方法****** [入参]：name = "+name);
        return "Hello!"+name+",i'm a micro service client , my port is "+port;
    }

}
