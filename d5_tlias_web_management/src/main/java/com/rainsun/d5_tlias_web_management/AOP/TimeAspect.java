//package com.rainsun.d5_tlias_web_management.AOP;
//
//import lombok.extern.slf4j.Slf4j;
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.Around;
//import org.aspectj.lang.annotation.Aspect;
//import org.springframework.stereotype.Component;
//
//@Aspect // 表面当前类是切面类
//@Slf4j
//@Component
//public class TimeAspect {
//
//    @Around("execution(* com.rainsun.d5_tlias_web_management.service.*.*(..))")
//    public Object recordTime(ProceedingJoinPoint pjp) throws Throwable {
//        long begin = System.currentTimeMillis();
//
//        Object result = pjp.proceed();
//
//        long end = System.currentTimeMillis();
//
//        log.info(pjp.getSignature() + "执行耗时：{} 毫秒", end-begin);
//        return result;
//    }
//
//}
