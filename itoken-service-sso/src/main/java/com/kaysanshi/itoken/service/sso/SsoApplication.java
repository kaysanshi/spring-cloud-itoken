package com.kaysanshi.itoken.service.sso;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @Author kay三石
 * @date:2019/6/28
 */
@EnableEurekaClient
@EnableDiscoveryClient //服务消费和提供者
@EnableFeignClients
@SpringBootApplication(exclude={DataSourceAutoConfiguration.class},scanBasePackages = "com.kaysanshi.itoken")
@MapperScan(value = "com.kaysanshi.itoken.service.sso.mapper")
public class SsoApplication {
    public static void main(String[] args) {
        SpringApplication.run(SsoApplication.class,args);
    }
}
