package com.kaysanshi.itoken.web.controller;

import com.kaysanshi.itoken.common.domain.BaseDomain;
import com.kaysanshi.itoken.common.utils.MapperUtils;
import com.kaysanshi.itoken.web.componenrs.datatables.DataTablesResult;
import com.kaysanshi.itoken.web.service.BaseClientService;
import org.springframework.beans.factory.annotation.Autowired;
import javax.servlet.http.HttpServletRequest;

/**
 * @Author kay三石
 * @date:2019/8/24
 * 通用的Controller
 */
public abstract class BaseController<T extends BaseDomain, S extends BaseClientService> {
    /**
     * 注入业务逻辑层
     */
    @Autowired
    protected  S service;

    public DataTablesResult page(HttpServletRequest request){
        String strDraw = request.getParameter("draw");
        String strStart = request.getParameter("start");
        String strLength = request.getParameter("length");

        int draw = strDraw== null ? 0 : Integer.parseInt(strDraw);
        int start = strStart== null ? 0 : Integer.parseInt(strStart);
        int length = strLength== null ? 0 : Integer.parseInt(strLength);

        String json = service.page(start, length, null);

        DataTablesResult dataTablesResult = null;
        try {
            dataTablesResult = MapperUtils.json2pojo(json, DataTablesResult.class);
            dataTablesResult.setDraw(draw);
            dataTablesResult.setRecordsTotal(dataTablesResult.getCursor().getTotal());
            dataTablesResult.setRecordsFiltered(dataTablesResult.getCursor().getTotal());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dataTablesResult;
    }
}
