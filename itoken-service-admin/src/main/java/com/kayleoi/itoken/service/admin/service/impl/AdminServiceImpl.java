package com.kayleoi.itoken.service.admin.service.impl;

import com.kayleoi.itoken.common.domain.TbSysUser;
import com.kayleoi.itoken.service.admin.mapper.TbSysUserMapper;
import com.kayleoi.itoken.service.admin.service.AdminServcie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import tk.mybatis.mapper.entity.Example;

/**
 * @Author kay三石
 * @date:2019/6/19
 */
@Service(value="AdminServiceImpl")
public class AdminServiceImpl implements AdminServcie {
    @Autowired
    TbSysUserMapper mapper;

    @Override
    public boolean register(TbSysUser user) {
        //密碼加密
        user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
        int  status= mapper.insert(user);

        if (status!=0){
            System.out.println(status+"注册成功 ");
            return true;
        }else{
            return false;
        }

    }

    @Override
    public TbSysUser login(String loginCode, String passWord) {
        Example example=new Example(TbSysUser.class);
        example.createCriteria().andEqualTo("loginCode",loginCode);
        TbSysUser user = mapper.selectOneByExample(example);
        String pwd = DigestUtils.md5DigestAsHex(passWord.getBytes());
        if (pwd.equals(user.getPassword()))
            return user;
        return null;
    }
}
