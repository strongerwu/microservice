package com.stronger.web;

import com.stronger.service.HomeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * feign
 * Created by wuqiang on 2017/11/10-0010.
 */
@RestController
@RequestMapping(value = "/home/")
public class HomeController {

    Logger log = LoggerFactory.getLogger(HomeController.class);

    @Autowired
    private HomeService homeService;

    @RequestMapping(value = "feignHello")
    public String feignHello(String name){
        log.info("*************进入 feignHome方法 *******入参 [name]:"+name);
        return homeService.hello(name);
    }

}
