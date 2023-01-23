package com.ct.tribe.handler;

import com.ct.tribe.common.HttpCode;
import com.ct.tribe.common.Result;
import com.ct.tribe.exception.BusinessException;
import com.ct.tribe.utils.ResultUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author CT
 * @description
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    @ExceptionHandler(BusinessException.class)
    public Result businessExceptionHandler(BusinessException e){
        log.error("businessException:" + e.getMessage(),e);
        return ResultUtils.error(e.getCode(),e.getMessage());
    }

    @ExceptionHandler(RuntimeException.class)
    public Result runtimeExceptionHandler(RuntimeException e){
        log.error("runtimeException: " + e ,e);
        return ResultUtils.error(HttpCode.SYSTEM_ERROR.getCode(),e.getMessage());
    }
}
