package com.kayleoi.itoken.service.admin;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import tk.mybatis.spring.annotation.MapperScan;


/**
 * 管理员服务提供者：暴露出接口供其他服务调用
 * @Author kay三石
 * @date:2019/6/18
 */
//注入数据源(exclude = {DataSourceAutoConfiguration.class})不能启动
@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
@EnableEurekaClient
@MapperScan(basePackages = "com.kayleoi.itoken.service.admin.mapper")
public class ServiceAdminApplication {

    public static void main(String[] args){
        SpringApplication.run(ServiceAdminApplication.class,args);
    }
}
