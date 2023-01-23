package com.ct.tribe.exception;

import com.ct.tribe.common.HttpCode;

/**
 * @author CT
 * @description 自定义异常
 */
public class BusinessException extends RuntimeException{
    private final int code;

    public int getCode(){
        return code;
    }

    public BusinessException(String message,int code){
        super(message);
        this.code = code;
    }

    public BusinessException(HttpCode httpCode){
        super(httpCode.getMessage());
        this.code = httpCode.getCode();
    }
    public BusinessException(HttpCode httpCode,String message){
        super(message);
        this.code = httpCode.getCode();
    }
}
