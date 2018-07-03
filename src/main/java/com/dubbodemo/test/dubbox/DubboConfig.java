package com.dubbodemo.test.dubbox;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ProtocolConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DubboConfig {

//    /*与<dubbo:annotation/>相当.提供方扫描带有@com.alibaba.dubbo.config.annotation.Service的注解类*/
//    @Bean
//    public static AnnotationBean annotationBean() {
//        AnnotationBean annotationBean = new AnnotationBean();
//        annotationBean.setPackage("org.exam.app.service");//所以含有@com.alibaba.dubbo.config.annotation.Service的注解类都应在此包中,多个包名可以使用英文逗号分隔.
//        return annotationBean;
//    }

    /*与<dubbo:application/>相当.*/
    @Bean
    public ApplicationConfig applicationConfig() {
        ApplicationConfig applicationConfig = new ApplicationConfig();
        applicationConfig.setName("demotest-provider");
        applicationConfig.setOwner("programmer");
        applicationConfig.setOrganization("dubbox");
        return applicationConfig;
    }

    /*与<dubbo:registry/>相当*/
    @Bean
    public RegistryConfig registryConfig() {
        RegistryConfig registryConfig = new RegistryConfig();
        registryConfig.setAddress("zookeeper://10.10.250.130:2181");
        registryConfig.setClient("zkclient");
        return registryConfig;
    }

    /*与<dubbo:protocol/>相当*/
    @Bean
    public ProtocolConfig protocolConfig(){
        ProtocolConfig protocolConfig=new ProtocolConfig("rest",8999);
        protocolConfig.setThreads(500);
        protocolConfig.setContextpath("services");
        protocolConfig.setServer("tomcat");
        protocolConfig.setAccepts(500);
        protocolConfig.setExtension("com.alibaba.dubbo.rpc.protocol.rest.support.LoggingFilter");
        return protocolConfig;
    }




}
