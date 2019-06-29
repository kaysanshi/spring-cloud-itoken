package com.kayleoi.itoken.service.admin.test.service;

import com.kayleoi.itoken.service.admin.ServiceAdminApplication;
import com.kayleoi.itoken.service.admin.domain.TbSysUser;
import com.kayleoi.itoken.service.admin.service.AdminServcie;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.UUID;

/**
 * 测试驱动
 * @Author kay三石
 * @date:2019/6/19
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ServiceAdminApplication.class)
@ActiveProfiles(value = "dev")
@Transactional
@Rollback
public class AdminServiceTest {

    @Autowired
    AdminServcie adminServcie;

    @Test
    public void login(){
        TbSysUser tbSysUser = adminServcie.login("kay", "123");
        Assert.assertNotNull(tbSysUser);
    }
    @Test
    public void regist(){
        TbSysUser user=new TbSysUser();
        user.setUserCode(UUID.randomUUID().toString());
        user.setLoginCode("kay");
        user.setPassword("123");
        user.setUserType("0");
        user.setMgrType("1");
        user.setCreateDate(new Date());
        user.setCreateBy(user.getUserCode());
        user.setUpdateBy(user.getUserCode());
        user.setCorpCode("0");
        user.setCorpName("itoken");
        user.setUserName("kay三石");
        user.setStatus("1");
        user.setUpdateDate(new Date());
        adminServcie.register(user);
    }
}
