package com.kayleoi.itoken.service.admin.service;

import com.kayleoi.itoken.common.domain.TbSysUser;
import com.kayleoi.itoken.common.domain.TbSysUser;


/**
 * @Author kay三石
 * @date:2019/6/19
 */

public interface AdminServcie {
    /**
     * 注册
     * @param user
     */
    public boolean register(TbSysUser user);

    /**
     *登录
     */
    public TbSysUser login(String loginCode, String passWord);
}
