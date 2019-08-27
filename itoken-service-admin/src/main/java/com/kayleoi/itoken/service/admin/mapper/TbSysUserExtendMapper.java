package com.kayleoi.itoken.service.admin.mapper;

import com.kayleoi.itoken.common.domain.TbSysUser;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.MyMapper;

/**
 * 扩展的mapper 接口，这里扩展自家的业务
 */
@Mapper
public interface TbSysUserExtendMapper extends MyMapper<TbSysUser> {
}