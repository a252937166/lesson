package com.ouyang.lesson.config;

import com.ouyang.lesson.response.MyResponse;
import com.ouyang.lesson.response.ResponseEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.validation.BindException;

import java.util.Objects;

/**
 * @author Administrator
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    /**
     * post请求参数校验抛出的异常
     * @param e
     * @return
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public MyResponse methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e){
        log.error("参数校验失败:{}",e.getMessage());
        //获取异常中随机一个异常信息
        String defaultMessage = Objects.requireNonNull(e.getBindingResult().getFieldError()).getDefaultMessage();
        return MyResponse.fail(defaultMessage);
    }

    /**
     * get请求参数校验抛出的异常
     * @param e
     * @return
     */
    @ExceptionHandler(BindException.class)
    public MyResponse bindExceptionHandler(BindException e){
        log.error("参数校验失败:{}",e.getMessage());
        //获取异常中随机一个异常信息
        String defaultMessage = Objects.requireNonNull(e.getBindingResult().getFieldError()).getDefaultMessage();
        return MyResponse.fail(defaultMessage);
    }

    /**
     * 其他异常
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    public MyResponse constraintViolationExceptionHandler(Exception e){
        log.error("其他异常:{}",e.getMessage());
        //获取异常中第一个错误信息
        MyResponse response = new MyResponse(ResponseEnum.FAIL);
        response.setMsg(e.getMessage());
        return response;
    }
}