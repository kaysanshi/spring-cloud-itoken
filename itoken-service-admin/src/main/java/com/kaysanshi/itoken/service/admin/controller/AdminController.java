package com.kaysanshi.itoken.service.admin.controller;

import com.github.pagehelper.PageInfo;
import com.kaysanshi.itoken.common.dto.BaseResult;
import com.kaysanshi.itoken.common.domain.TbSysUser;
import com.kaysanshi.itoken.common.utils.MapperUtils;
import com.kaysanshi.itoken.service.admin.service.AdminService;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/**
 * @Author kay三石
 * @date:2019/6/22
 */
@RestController
@RequestMapping(value = "v1/admins")
public class AdminController {

    @Autowired
    private AdminService adminService;
    /**
     * 根据 ID 获取管理员
     *
     * @param userCode
     * @return
     */
    @ApiOperation(value ="获取管理员信息" )
    @RequestMapping(value = "{userCode}", method = RequestMethod.GET)
    public BaseResult get(String userCode) {
        TbSysUser tbSysUser = new TbSysUser();
        tbSysUser.setUserCode(userCode);
        TbSysUser obj = (TbSysUser) adminService.selectOne(tbSysUser);
        return BaseResult.ok(obj);
    }

    /**
     * 保存管理员
     *
     * @return
     */
    @ApiOperation(value = "保存管理员信息")
    @RequestMapping(method = RequestMethod.POST)
    public BaseResult save(
            @RequestParam(required = true) String tbSysUserJson,
            @RequestParam(required = true) String optsBy
    ) {
        int result = 0;

        TbSysUser tbSysUser = null;
        try {
            tbSysUser = MapperUtils.json2pojo(tbSysUserJson, TbSysUser.class);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (tbSysUser != null) {
            // 密码加密
            String password = DigestUtils.md5DigestAsHex(tbSysUser.getPassword().getBytes());
            tbSysUser.setPassword(password);

            // 新增用户
            if (StringUtils.isBlank(tbSysUser.getUserCode())) {
                tbSysUser.setUserCode(UUID.randomUUID().toString());
                result = adminService.insert(tbSysUser, optsBy);
            }

            // 修改用户
            else {
                result = adminService.update(tbSysUser, optsBy);
            }

            // 最少有一行数据受影响
            if (result > 0) {
                return BaseResult.ok("保存管理员成功");
            }
        }

        return BaseResult.ok("保存管理员失败");
    }

    /**
     * 分页的数据
     *
     * @param pageNum
     * @param pageSize
     * @param tbSysUser
     * @return
     */
    @ApiOperation(value = "分页数据")
    @RequestMapping(value = "page/{pageNum}/{pageSize}", method = RequestMethod.GET)
    public BaseResult page(
            @PathVariable(required = true) int pageNum,
            @PathVariable(required = true) int pageSize,
            @RequestParam(required = false) TbSysUser tbSysUser) {

        PageInfo pageInfo = adminService.page(pageNum, pageSize, tbSysUser);
        List <TbSysUser> list = pageInfo.getList();
        //封装Cursor
        BaseResult.Cursor cursor = new BaseResult.Cursor();
        cursor.setTotal(new Long(pageInfo.getTotal()).intValue());
        cursor.setOffset(pageInfo.getPageNum());
        cursor.setLimit(pageInfo.getPageSize());
        return BaseResult.ok(list, cursor);

    }
}
