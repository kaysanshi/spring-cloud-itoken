package com.kaysanshi.itoken.web.posts.service;

import com.kaysanshi.itoken.web.posts.service.fallback.PostsServiceFallBack;
import com.kaysanshi.itoken.web.service.BaseClientService;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author kay三石
 * @date:2019/8/24
 * 继承通用的服务者消费的接口
 */
@FeignClient(value = "itoken-posts-service", fallback = PostsServiceFallBack.class)
public interface PostsService extends BaseClientService {
    /**
     * @PathVariable:路径参数
     * @RequestParam：request请求中的data参数
     * @param PageNum
     * @param pageSize
     * @param tbPostsPostJson
     * @return
     */
    @RequestMapping(value = "v1/posts/page/{pageNum}/{pageSize}",method = RequestMethod.GET)
    public String page(
            @PathVariable(required = true,value = "pageNum") int PageNum,
            @PathVariable(required = true,value = "pageSize") int pageSize,
            @RequestParam(required = false, value = "tbPostsPostJson") int tbPostsPostJson
            );

    /**
     * 用于获得文章
     * @param postGuid
     * @return
     */
    @RequestMapping(value = "v1/posts/{postGuid}", method = RequestMethod.GET)
    public String get(
            @PathVariable(required = true, value = "postGuid") String postGuid
    );

    /**
     * 保存文章
     * @param tbPostsPostJson
     * @param optsBy
     * @return
     */
    @RequestMapping(value = "v1/posts", method = RequestMethod.POST)
    public String save(
            @RequestParam(required = true, value = "tbPostsPostJson") String tbPostsPostJson,
            @RequestParam(required = true, value = "optsBy") String optsBy
    );
}
