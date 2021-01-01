package com.atguigu.boot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@Slf4j
@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String handle01() {

//        log.info("请求进来了....");
        return "Hello,Spring Boot 2!" + "你好：" ;
    }

//    @Autowired
//    Car car;
//
//
//    @RequestMapping("/car")
//    public Car car() {
//        return car;
//    }


}
