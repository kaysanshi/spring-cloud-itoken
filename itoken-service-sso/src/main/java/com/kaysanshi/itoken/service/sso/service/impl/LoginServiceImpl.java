package com.kaysanshi.itoken.service.sso.service.impl;

import com.kaysanshi.itoken.common.domain.TbSysUser;
import com.kaysanshi.itoken.common.utils.MapperUtils;
import com.kaysanshi.itoken.service.sso.mapper.TbSysUserMapper;
import com.kaysanshi.itoken.service.sso.service.LoginServcie;
import com.kaysanshi.itoken.service.sso.service.consumer.RedisService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.DigestUtils;
import tk.mybatis.mapper.entity.Example;

/**
 * @Author kay三石
 * @date:2019/6/28
 */
@Repository
public class LoginServiceImpl implements LoginServcie {

    private static final Logger logger= LoggerFactory.getLogger(LoginServiceImpl.class);
    @Autowired
    TbSysUserMapper mapper;

    @Autowired
    private RedisService redisService;
    @Autowired
    TbSysUser user;

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

        String json=redisService.get(loginCode);
        //缓存中没有数据
        if (json==null){
            Example example=new Example(TbSysUser.class);
            example.createCriteria().andEqualTo("loginCode",loginCode);
             user = mapper.selectOneByExample(example);
            String pwd = DigestUtils.md5DigestAsHex(passWord.getBytes());
            if (pwd.equals(user.getPassword())){
                try {
                    //加入到缓存中
                    redisService.put(loginCode, MapperUtils.obj2json(user),60*60*24);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return user;
            }else{
                return null;
            }

        }else{
            //缓存中有数据：
            try {
                user = MapperUtils.json2pojo(json, TbSysUser.class);
            } catch (Exception e) {
                logger.warn("触发熔断:{}",e.getMessage());


            }

        }
        return user;
    }
}
