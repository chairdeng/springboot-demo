package com.example.springboot.controller.advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;

/**
 * *****************************************
 *
 * @author 邓超【dengchao5@jd.com】
 * @date 2017/4/5 18:54
 * *****************************************
 */
@RestControllerAdvice("com.example.springboot.controller")
public class RestAdvice {

    @ResponseStatus(value= HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ErrorResult handleMethodArgumentNotValidException(MethodArgumentNotValidException ex, HttpServletRequest request){
        ErrorResult response = new ErrorResult();
        response.setErrorMessage(ex.getBindingResult().getAllErrors().get(0).getDefaultMessage());
        response.setErrorCode("0001");
        return response;
    }

    @ResponseStatus(value= HttpStatus.BAD_REQUEST)
    @ExceptionHandler({ConstraintViolationException.class})
    public ErrorResult handleConstraintViolationException(ConstraintViolationException ex){
        ErrorResult result = new ErrorResult();
        result.setErrorMessage(ex.getConstraintViolations().iterator().next().getMessage());
        result.setErrorCode("0001");
        return result;
    }

    @ResponseStatus(value= HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public ErrorResult handleException(Exception ex){
        ErrorResult errorResult = new ErrorResult();
        errorResult.setErrorCode("9999");
        errorResult.setErrorMessage("未知错误");
        return errorResult;
    }

}
