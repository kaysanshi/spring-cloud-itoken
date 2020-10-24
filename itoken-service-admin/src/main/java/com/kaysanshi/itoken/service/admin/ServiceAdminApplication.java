package com.kaysanshi.itoken.service.admin;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import tk.mybatis.spring.annotation.MapperScan;


/**
 * 管理员服务提供者：暴露出接口供其他服务调用
 * @Author kay三石
 * @date:2019/6/18
 * 由于创建了公共的属性的mapper所以在扫描的时候要多加一个扫描
 */
//注入数据源(exclude = {DataSourceAutoConfiguration.class})不能启动
@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
@EnableEurekaClient
@EnableSwagger2
@MapperScan(basePackages = {"com.kaysanshi.itoken.commmon.mapper","tk.mybatis.mapper.MyMapper","com.kaysanshi.itoken.service.admin.mapper"})
public class ServiceAdminApplication {

    public static void main(String[] args){
        SpringApplication.run(ServiceAdminApplication.class,args);
    }
}
