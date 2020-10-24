package com.kaysanshi.itoken.common.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @Author kay三石
 * @date:2019/6/22
 */
@Data
public class BaseResult implements Serializable {

    public static final String RESULT_OK="ok";
    public static final String RESULT_NOT_OK="not_ok";
    public static final String SUCCESS="成功操作";
    private String result;
    private Object data;
    private String success;
    private Cursor cursor;

    private List<Error> errors;

    /**
     * 成功操作
     * 并返回数据
     * @param data
     * @return
     */
    public static BaseResult ok(Object data){
        return createResult(RESULT_OK,data,SUCCESS,null,null);
    }

    /**
     * 成功操作
     * 返回状态码success
     * @param success
     * @return
     */
    public static BaseResult ok(String success) {
        return createResult(RESULT_OK, null, success, null, null);
    }
    /**
     * 成功操作但是不返回结果
     * @return
     */
    public static BaseResult ok(){
        return createResult(RESULT_OK,null,SUCCESS,null,null);

    }

    /**
     * 分页数据的返回封装
     * @param data
     * @param cursor
     * @return
     */
    public static BaseResult ok(Object data, Cursor cursor){
        return createResult(RESULT_OK, data, SUCCESS, cursor, null);
    }
    /**
     * 失败的
     * @param errors
     * @return
     */
    public static BaseResult notOk(List<BaseResult.Error> errors){
        return createResult(RESULT_NOT_OK,null,"",null,errors);

    }

    /**
     *创建返回结果
     * @param result
     * @param data
     * @param success
     * @param cursor
     * @param errors
     * @return
     */
    private static BaseResult createResult(String result, Object data,String success,Cursor cursor,List<Error> errors){
        BaseResult baseResult=new BaseResult();
        baseResult.setResult(result);
        baseResult.setData(data);
        baseResult.setSuccess(success);
        baseResult.setErrors(errors);
        baseResult.setCursor(cursor);
        return baseResult;
    }
    @Data
    public static class Cursor{
        private int total;
        private int offset;
        private int limit;
    }

    @Data
    @AllArgsConstructor
    public static class Error{
        private String field;
        private String message;
    }
}
