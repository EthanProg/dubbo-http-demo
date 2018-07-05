package com.dubbodemo.test.dubbox.annotation;

import com.dubbodemo.test.dubbox.annotation.consumer.DemoConsumerCom;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

public class DemoConsumer {

    public static void main(String[] args) {
        final String port = "8999";

//        //测试Rest服务
        getUser("http://127.0.0.1:" + port + "/services/users/1.json");
        getUser("http://127.0.0.1:" + port + "/services/users/2.xml");

        //测试常规服务
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring/dubbox-anno-consumer.xml");
        context.start();

//        UserRestService userRestService = context.getBean(UserRestService.class);
//        System.out.println(userRestService.getUser(3L));

        // 若找不到bean 则加载spring-mvc.xml
        DemoConsumerCom demoConsumerCom = context.getBean(DemoConsumerCom.class);
        System.out.println(demoConsumerCom.getUser(4L));
    }


    private static void getUser(String url) {
        System.out.println("Getting user via " + url);
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target(url);
        Response response = target.request().get();
        try {
            if (response.getStatus() != 200) {
                throw new RuntimeException("Failed with HTTP error code : " + response.getStatus());
            }
            System.out.println("Successfully got result: " + response.readEntity(String.class));
        } finally {
            response.close();
            client.close();
        }
    }
}