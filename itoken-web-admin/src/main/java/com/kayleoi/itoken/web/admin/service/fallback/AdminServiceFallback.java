package com.kayleoi.itoken.web.admin.service.fallback;

import com.google.common.collect.Lists;
import com.kayleoi.itoken.common.constants.HttpStatusConstants;
import com.kayleoi.itoken.common.dto.BaseResult;
import com.kayleoi.itoken.common.hystrix.FallBack;
import com.kayleoi.itoken.common.utils.MapperUtils;
import com.kayleoi.itoken.web.admin.service.AdminService;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

/**
 * @Author kay三石
 * @date:2019/6/22
 */
@Component
public class AdminServiceFallback implements AdminService {

    @Override
    public String get(String userCode) {
        return FallBack.badGateway();    }

    @Override
    public String save(String tbSysUserJson, String optsBy) {
        return FallBack.badGateway();    }

    @Override
    public String page(int pageNum, int pageSize, String tbSysUserJson) {
        return FallBack.badGateway();    }
}
