package com.kaysanshi.itoken.web.service;

import com.kaysanshi.itoken.common.hystrix.FallBack;

/**
 * @Author kay三石
 * @date:2019/8/24
 * 通用的服务消费者接口
 */
public interface BaseClientService {
    /**
     * 分页
     * jdk8中新的特性(default)
     * @param pageNum
     * @param pageSize
     * @param domainJson
     * @return
     */
    default String page(int pageNum, int pageSize, String domainJson) {
        return FallBack.badGateway();
    }
}
