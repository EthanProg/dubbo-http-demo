package com.dubbodemo.test.dubbox;

public class UserServiceImpl implements UserService {

    @Override
    public User getUser(Long id) {
        return new User(id, "username" + id);
    }
}
