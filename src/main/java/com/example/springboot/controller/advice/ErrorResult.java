package com.example.springboot.controller.advice;

import lombok.Data;

/**
 * *****************************************
 *
 * @author 邓超【dengchao5@jd.com】
 * @date 2017/4/5 19:03
 * *****************************************
 */
@Data
public class ErrorResult {
    private String errorCode;
    private String errorMessage;

}
