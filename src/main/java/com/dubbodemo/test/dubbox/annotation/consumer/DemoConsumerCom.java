package com.dubbodemo.test.dubbox.annotation.consumer;

import com.alibaba.dubbo.config.annotation.Reference;
import com.dubbodemo.test.dubbox.annotation.services.User;
import com.dubbodemo.test.dubbox.annotation.services.UserRestService;
import org.springframework.stereotype.Controller;

/**
 * Created by liwenqing on 18-7-4.
 */
@Controller
public class DemoConsumerCom {

    @Reference
    private UserRestService userRestService;

    public User getUser(Long id){
        return userRestService.getUser(id);
    }
}
