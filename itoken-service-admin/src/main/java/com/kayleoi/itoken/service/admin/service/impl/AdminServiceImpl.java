package com.kayleoi.itoken.service.admin.service.impl;

import com.kayleoi.itoken.common.domain.TbSysUser;
import com.kayleoi.itoken.common.mapper.TbSysUserMapper;
import com.kayleoi.itoken.common.service.impl.BaseServiceImpl;
import com.kayleoi.itoken.service.admin.service.AdminService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author kay三石
 * @date:2019/6/19
 */
@Service
@Transactional(readOnly = true)
public class AdminServiceImpl extends BaseServiceImpl<TbSysUser, TbSysUserMapper> implements AdminService<TbSysUser> {

}
