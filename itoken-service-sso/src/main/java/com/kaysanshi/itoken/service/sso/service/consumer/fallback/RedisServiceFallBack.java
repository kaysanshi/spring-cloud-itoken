package com.kaysanshi.itoken.service.sso.service.consumer.fallback;

import com.google.common.collect.Lists;
import com.kaysanshi.itoken.common.constants.HttpStatusConstants;
import com.kaysanshi.itoken.common.dto.BaseResult;
import com.kaysanshi.itoken.common.utils.MapperUtils;
import com.kaysanshi.itoken.service.sso.service.consumer.RedisService;
import org.springframework.stereotype.Component;

/**
 *熔断
 * @Author kay三石
 * @date:2019/6/28
 */
@Component
public class RedisServiceFallBack implements RedisService {
    @Override
    public String put(String key, String vlaue, long seconds) {
        try {
            return MapperUtils.obj2json(BaseResult.notOk(
                    Lists.newArrayList(
                            new BaseResult.Error(String.valueOf(HttpStatusConstants.BAD_GATEWAY.getStatus()),
                                    HttpStatusConstants.BAD_GATEWAY.getContent()))));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  null;
    }

    @Override
    public String get(String key) {
        try {
            return MapperUtils.obj2json(BaseResult.notOk(
                    Lists.newArrayList(
                            new BaseResult.Error(String.valueOf(HttpStatusConstants.BAD_GATEWAY.getStatus()),
                                    HttpStatusConstants.BAD_GATEWAY.getContent()))));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  null;
    }
}
