package com.dubbodemo.test.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by liwenqing on 2018/6/26.
 */
@RestController
public class TestController {

    @RequestMapping("/test")
    public String test() {
        return "hello Spring MVC";
    }


}
