package com.dubbodemo.test.dubbox.annotation.provider;


import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.dubbo.rpc.RpcContext;
import com.dubbodemo.test.dubbox.annotation.services.User;
import com.dubbodemo.test.dubbox.annotation.services.UserRestService;
import com.dubbodemo.test.dubbox.annotation.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.PathParam;

@Service(protocol = "rest", validation = "true")
public class UserRestServiceImpl implements UserRestService {

    @Autowired
    private UserService userService;

    @Override
    public User getUser(@PathParam("id") Long id) {
        if (RpcContext.getContext().getRequest(HttpServletRequest.class) != null) {
            System.out.println("Client IP address from RpcContext: " + RpcContext.getContext().getRequest(HttpServletRequest.class).getRemoteAddr());
        }
        if (RpcContext.getContext().getResponse(HttpServletResponse.class) != null) {
            System.out.println("Response object from RpcContext: " + RpcContext.getContext().getResponse(HttpServletResponse.class));
        }
        return userService.getUser(id);
    }
}