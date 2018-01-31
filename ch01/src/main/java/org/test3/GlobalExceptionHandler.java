package org.test3;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by langye on 2017/12/13.
 * @ControllerAdvice 切面注解  这个类用于捕获异常
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    @ResponseBody //拦截返回json结果
    public Map<String,Object> exceptionHandler(){
        Map<String,Object> result = new HashMap<String, Object>();
        result.put("code","500");
        result.put("msg","系统错误，请重试...");
        return result;
    }
}
