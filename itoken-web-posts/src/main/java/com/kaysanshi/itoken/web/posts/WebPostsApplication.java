package com.kaysanshi.itoken.web.posts;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author kay三石
 * @date:2019/8/24
 * posts服务的消费者
 */
@SpringBootApplication(scanBasePackages = "com.kaysanshi.itoken")
@EnableDiscoveryClient
@EnableFeignClients
public class WebPostsApplication {
}
