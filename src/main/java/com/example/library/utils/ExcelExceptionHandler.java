package com.example.library.utils;


import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 全局异常处理（抛到前台）

 */
@ControllerAdvice
public class ExcelExceptionHandler {
    @ExceptionHandler(value = ExcelException.class)
    @ResponseBody
    public ResponseResult handlerCouponException(ExcelException exception ) {
        return ResponseResultUtils.error(exception.getStatus(),exception.getMessage());
    }
}
