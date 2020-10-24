package com.kaysanshi.itoken.service.posts.controller;

import com.github.pagehelper.PageInfo;
import com.kaysanshi.itoken.common.domain.TbPostsPost;
import com.kaysanshi.itoken.common.dto.BaseResult;
import com.kaysanshi.itoken.common.utils.MapperUtils;
import com.kaysanshi.itoken.common.utils.StringUtils;
import com.kaysanshi.itoken.service.posts.service.PostsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/**
 * @Author kay三石
 * @date:2019/8/4
 */
@RestController
@RequestMapping(value = "v1/posts")
@Api(value = "文章服务控制器")
public class PostsController {
    @Autowired
    private PostsService<TbPostsPost> postsService;

    /**
     *通过id获得文章
     * @param postGuid
     * @return
     */
    @ApiOperation(value = "获得文章通过id")
    @RequestMapping(value = "{postGuid}", method = RequestMethod.GET)
    public  BaseResult get(@PathVariable(value = "postGuid") String postGuid){
        TbPostsPost tbPostsPost = new TbPostsPost();
        tbPostsPost.setPostGuid(postGuid);
        TbPostsPost tbPostsPost1 = postsService.selectOne(tbPostsPost);
        return BaseResult.ok(tbPostsPost1);
    }

    /**
     * 保存文章
     * @param tbPostsPostJson
     * @param optsBy
     * @return
     */
    @ApiOperation(value = "保存文章")
    @RequestMapping(value = "save",method = RequestMethod.POST)
    public BaseResult save(
            @RequestParam(required = true) String tbPostsPostJson,
            @RequestParam(required = true) String optsBy){

        int result = 0;

        TbPostsPost tbPostsPost=null;
        try {
            tbPostsPost = MapperUtils.json2pojo(tbPostsPostJson,TbPostsPost.class);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (tbPostsPost !=null ){
            //主键为null表示新增
            if (StringUtils.isBlank(tbPostsPost.getPostGuid())){
                tbPostsPost.setPostGuid(UUID.randomUUID().toString());
                result = postsService.insert(tbPostsPost, optsBy);
            }else{
                //编辑：
                result =postsService.update(tbPostsPost,optsBy);
            }
            if (result>0){
                return BaseResult.ok("保存文章成功");
            }

        }
        return  BaseResult.ok("保存文章失败");
    }
    /**
     * 分页查询
     *
     * @param pageNum
     * @param pageSize
     * @param tbPostsPostJson
     * @return
     */
    @ApiOperation(value = "文章服务分页查询接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "页码", required = true, dataType = "int", paramType = "path"),
            @ApiImplicitParam(name = "pageSize", value = "笔数", required = true, dataType = "int", paramType = "path"),
            @ApiImplicitParam(name = "tbPostsPostJson", value = "对象 JSON 格式", required = false, dataTypeClass = String.class, paramType = "json")
    })
    @RequestMapping(value = "page/{pageNum}/{pageSize}", method = RequestMethod.GET)
    public BaseResult page(
            @PathVariable(required = true) int pageNum,
            @PathVariable(required = true) int pageSize,
            @RequestParam(required = false) String tbPostsPostJson
    ) throws Exception {

        TbPostsPost tbPostsPost = null;
        if (StringUtils.isNotBlank(tbPostsPostJson)) {
            tbPostsPost = MapperUtils.json2pojo(tbPostsPostJson, TbPostsPost.class);
        }

        PageInfo pageInfo = postsService.page(pageNum, pageSize, tbPostsPost);

        // 分页后的结果集
        List<TbPostsPost> list = pageInfo.getList();

        // 封装 Cursor 对象
        BaseResult.Cursor cursor = new BaseResult.Cursor();
        cursor.setTotal(new Long(pageInfo.getTotal()).intValue());
        cursor.setOffset(pageInfo.getPageNum());
        cursor.setLimit(pageInfo.getPageSize());

        return BaseResult.ok(list, cursor);
    }

}
