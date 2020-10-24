package com.kaysanshi.itoken.service.admin.mapper;

import com.kaysanshi.itoken.common.domain.TbSysUser;
import org.apache.ibatis.annotations.Mapper;
import tk.mybatis.mapper.MyMapper;

/**
 * 扩展的mapper 接口，这里扩展自家的业务
 */
@Mapper
public interface TbSysUserExtendMapper extends MyMapper<TbSysUser> {
}