package com.aibyd.apps.core.comp;

import com.alibaba.fastjson.JSONObject;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class SysCustomControllerAop {

    @Pointcut("execution(public * com.aibyd.apps.*.controller..*.*(..))")
    public void parseReqAndFormatRes() {

    }

    @Around("parseReqAndFormatRes()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        long start = System.currentTimeMillis();
        String className = point.getSignature().getClass().getName();
        System.out.println(className);
        String methodName = point.getSignature().getName();
        System.out.println(methodName);
        // JSONObject res = new JSONObject();
        Object res = null;
        Object[] args = point.getArgs();
        String params = "";
        for (Object object : args) {
            params += object.toString() + ",";
        }
        params = params.substring(0, params.length() - 1);
        System.out.println(className + " 类的 " + methodName + " 的 " + params);
        res = point.proceed();
        long end = System.currentTimeMillis();
        long time = end - start;
        System.out.println(methodName + " 方法执行时长为: " + time);
        return res;
    }

}