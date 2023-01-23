package com.ct.tribe.common;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author CT
 * @description 统一返回类
 */
@Data
@AllArgsConstructor
public class Result<T> {
    private int code;
    private T data;
    private String message;

    public Result(int code,T data){
        this(code,data,"");
    }
}
