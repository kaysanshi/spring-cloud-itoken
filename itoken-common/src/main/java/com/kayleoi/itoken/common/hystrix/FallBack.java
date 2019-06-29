package com.kayleoi.itoken.common.hystrix;

import com.google.common.collect.Lists;
import com.kayleoi.itoken.common.constants.HttpStatusConstants;
import com.kayleoi.itoken.common.dto.BaseResult;
import com.kayleoi.itoken.common.utils.MapperUtils;

/**
 * 通用的熔断方法
 * @Author kay三石
 * @date:2019/6/28
 */
public class FallBack {

    public static String badGateway() {

        BaseResult baseResult = BaseResult.notOk(
                Lists.newArrayList(
                        new BaseResult.Error(String.valueOf(HttpStatusConstants.BAD_GATEWAY.getStatus()),
                                HttpStatusConstants.BAD_GATEWAY.getContent())));
        try {
            return  MapperUtils.obj2json(baseResult);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
