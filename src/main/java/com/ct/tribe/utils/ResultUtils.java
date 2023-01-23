package com.ct.tribe.utils;

import com.ct.tribe.common.HttpCode;
import com.ct.tribe.common.Result;

/**
 * @author CT
 * @description 返回工具类
 */
public class ResultUtils {
    /**
     * @Author CT
     * @Description // 成功
     * @Date 11:44 2023/1/23
     * @Param [data]
     * @return com.ct.tribe.common.Result<T>
     **/
    public static <T> Result<T> ok(T data){
        return new Result<T>(HttpCode.SUCCESS.getCode(), data,HttpCode.SUCCESS.getMessage());
    }

    /**
     * @Author CT
     * @Description // 失败
     * @Date 11:46 2023/1/23
     * @Param [httpCode]
     * @return com.ct.tribe.common.Result
     **/
    public static Result error(HttpCode httpCode){
        return new Result(httpCode.getCode(),null,httpCode.getMessage());
    }

    public static Result error(int code, String message) {
        return new Result(code,null,message);
    }
}
