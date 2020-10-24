package com.kaysanshi.itoken.service.sso.service;

import com.kaysanshi.itoken.common.domain.TbSysUser;


/**
 * @Author kay三石
 * @date:2019/6/19
 */

public interface LoginServcie {
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
