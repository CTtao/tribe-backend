package com.ct.tribe.common;

/**
 * @Author CT
 * @Description 状态码
 **/
public enum HttpCode {
    SUCCESS(200,"ok"),
    NO_AUTH(401,"未登录或权限不足"),
    SYSTEM_ERROR(500,"系统服务出错"),
    PARAMS_ERROR(501,"参数错误"),
    ;

    /**
     * 状态码
     */
    private final int code;
    /**
     * 状态信息
     */
    private final String message;

    HttpCode(int code,String message){
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
