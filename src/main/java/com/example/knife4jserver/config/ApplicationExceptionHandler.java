package com.example.knife4jserver.config;

import com.example.knife4jserver.response.Response;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ApplicationExceptionHandler {

    @ExceptionHandler(Throwable.class)
    @ResponseBody
    public Response<Object> handlerException(Exception e){ //e 接收异常信息
        //获取异常信息，存放到 ResponseResult 的 msg 属性中
        String message = e.getMessage();
        //把 ResponseResult 作为返回值返回，要求到时候转换 json 存入到响应体中
        return Response.fail(message);
    }
}