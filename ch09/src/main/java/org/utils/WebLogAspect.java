package org.utils;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

/**
 * Created by langye on 2017/12/27.
 */
@Component
@Aspect
public class WebLogAspect {

    private static Logger logger = LoggerFactory.getLogger(WebLogAspect.class);

    //匹配com.zkn.learnspringboot.web.controller包及其子包下的所有类的所有方法
    @Pointcut("execution(public * org.controller..*.*(..))")
    public void webLog(){

    }

    /**
     * 前置通知，方法调用前被调用
     * @param joinPoint
     */
    @Before("webLog()")
    public void doBeforeAdvice(JoinPoint joinPoint){
        System.out.println("我是前置通知!!!");
        //获取目标方法的参数信息
        Object[] obj = joinPoint.getArgs();
        //AOP代理类的信息
        joinPoint.getThis();
        //代理的目标对象
        joinPoint.getTarget();
        //用的最多 通知的签名
        Signature signature = joinPoint.getSignature();
        //代理的是哪一个方法
        System.out.println(signature.getName());
        //AOP代理类的名字
        System.out.println(signature.getDeclaringTypeName());
        //AOP代理类的类（class）信息
        signature.getDeclaringType();
        //获取RequestAttributes
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        //从获取RequestAttributes中获取HttpServletRequest的信息
        HttpServletRequest request = (HttpServletRequest) requestAttributes.resolveReference(RequestAttributes.REFERENCE_REQUEST);
        //如果要获取Session信息的话，可以这样写：
        //HttpSession session = (HttpSession) requestAttributes.resolveReference(RequestAttributes.REFERENCE_SESSION);
        Enumeration<String> enumeration = request.getParameterNames();

        //记录下请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        //记录下请求内容
        logger.info("URL:"+request.getRequestURI().toString());
        logger.info("IP:"+request.getRemoteAddr());
        while(enumeration.hasMoreElements()){
            String name = enumeration.nextElement();
            logger.info("name:{},value:{}",name,request.getParameter(name));

        }
    }
    @AfterReturning(returning = "ret",pointcut = "webLog()")
    public void doAfterReturning(Object ret){
        //处理完请求，返回内容
        logger.info("RESPONSE:"+ret);
    }
}
