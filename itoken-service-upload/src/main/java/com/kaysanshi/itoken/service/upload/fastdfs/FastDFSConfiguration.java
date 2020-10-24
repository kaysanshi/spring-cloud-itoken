package com.kaysanshi.itoken.service.upload.fastdfs;

import org.springframework.context.annotation.Bean;

/**
 * Java 配置方式定义 StorageFactory 的 Bean 使其可以被依赖注入
 *  <p>Title: FastDFSConfiguration</p>
 *  <p>Description: </p>
 * @Author kay三石
 * @date:2019/8/25
 */
public class FastDFSConfiguration {
    @Bean
    public StorageFactory storageFactory() {
        return new StorageFactory();
    }
}

