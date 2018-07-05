package com.dubbodemo.test.dubbox.annotation;


import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class DemoProvider {
    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring/dubbox-anno-provider.xml");
        context.start();
        System.out.println("服务已经启动...");
        System.in.read();
    }
}