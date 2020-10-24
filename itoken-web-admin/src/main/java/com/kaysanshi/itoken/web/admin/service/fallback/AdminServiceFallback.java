package com.kaysanshi.itoken.web.admin.service.fallback;

import com.kaysanshi.itoken.common.hystrix.FallBack;
import com.kaysanshi.itoken.web.admin.service.AdminService;
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
