package com.huayu.handler;

import com.huayu.util.R;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全集异常处理器
 */
@RestControllerAdvice
public class GlobaExceptionHandler {
    /**
     *  @ExceptionHandler 指定异常
     * @param bindingResult
     * @return
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public R<String> exceptionHandler(BindingResult bindingResult){
       return R.error(bindingResult.getFieldError().getDefaultMessage());
    }
}
