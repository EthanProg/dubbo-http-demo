package com.dubbodemo.test.dubbo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Consumer {
    public static void main(String[] args) {
        //测试常规服务
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring/consumer.xml");
        context.start();
        System.out.println("consumer start");
//        DemoService demoService = context.getBean(DemoService.class);
        IDubboService dubboService = context.getBean(IDubboService.class);
        System.out.println("consumer");
        System.out.println(dubboService.getString());
    }
}
