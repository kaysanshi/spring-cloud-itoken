package com.kayleoi.itoken.service.admin.controller;

import com.google.common.collect.Lists;
import com.kayleoi.itoken.common.dto.BaseResult;
import com.kayleoi.itoken.common.domain.TbSysUser;
import com.kayleoi.itoken.service.admin.service.AdminServcie;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author kay三石
 * @date:2019/6/22
 */
@RestController
public class AdminController {

    @Autowired
    private AdminServcie adminServcie;

    /**
     * 登录
     * @param loginCode
     * @param password
     * @return
     */
    @RequestMapping(value = "login",method= RequestMethod.GET)
    public BaseResult login(String loginCode,String password){
        //检查登录信息
        BaseResult baseResult = checkLogin(loginCode, password);
        if(baseResult != null){
            return baseResult;
        }
        //登录业务
        TbSysUser loginUser = adminServcie.login(loginCode, password);
        //登录成功
        if(loginUser!=null){
            return BaseResult.ok(loginUser);
        }else{
            return BaseResult.notOk(Lists.newArrayList(new BaseResult.Error("","登录失败")));

        }

    }

    /**
     * 注册
     * @param user
     * @return
     */
    @RequestMapping(value = "register",method = RequestMethod.GET)
    public BaseResult register(TbSysUser user){

        if (user.getPassword()!=null&&user.getUserName()!=null){
            boolean status=adminServcie.register(user);
            if (status==true){
                return BaseResult.ok("注册成功");
            }else{
                return BaseResult.notOk(Lists.newArrayList(new BaseResult.Error("","注册失败")));
            }
        }else{
            return BaseResult.notOk(Lists.newArrayList(new BaseResult.Error("password","注册失败，验证码不可为空")));

        }
    }

    /**
     * 检查登录信息
     * @param loginCode
     * @param password
     * @return
     */
    public BaseResult checkLogin(String loginCode,String password){
        BaseResult baseResult=null;
//        List<BaseResult.Error> errors=new ArrayList <>();
//        这里使用谷歌的不自己用了
        List<BaseResult.Error> errors= Lists.newArrayList();
//        if (StringUtils.isBlank(loginCode)){
//            BaseResult.Error error=new BaseResult.Error();
//            error.setField("loginCode");
//            error.setMessage("登录账号不能为空");
//            errors.add(error);
//        }
//        if (StringUtils.isBlank(password)){
//            BaseResult.Error error=new BaseResult.Error();
//            error.setField("password");
//            error.setMessage("密码不能为空");
//            errors.add(error);
//        }
        if (StringUtils.isBlank(loginCode)||StringUtils.isBlank(password)){
            baseResult=BaseResult.notOk(Lists.newArrayList(
                    new BaseResult.Error("loginCode","登录账号不能为空"),
                     new BaseResult.Error("password","密码不能为空")

            ));
        }
        return baseResult;
    }
}
