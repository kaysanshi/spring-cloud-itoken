package com.kaysanshi.itoken.service.admin.service.impl;

import com.kaysanshi.itoken.common.domain.TbSysUser;
import com.kaysanshi.itoken.common.mapper.TbSysUserMapper;
import com.kaysanshi.itoken.common.service.impl.BaseServiceImpl;
import com.kaysanshi.itoken.service.admin.service.AdminService;
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
