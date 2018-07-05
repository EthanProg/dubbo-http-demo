package com.dubbodemo.test.dubbox.annotation.provider;

import com.alibaba.dubbo.config.annotation.Service;
import com.dubbodemo.test.dubbox.annotation.services.User;
import com.dubbodemo.test.dubbox.annotation.services.UserService;

@Service(protocol = "dubbo")
public class UserServiceImpl implements UserService {

    @Override
    public User getUser(Long id) {
        return new User(id, "username" + id);
    }
}
