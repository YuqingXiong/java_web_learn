package com.rainsun.d5_tlias_web_management.AOP;

import com.alibaba.fastjson.JSONObject;
import com.rainsun.d5_tlias_web_management.mapper.OperateLogMapper;
import com.rainsun.d5_tlias_web_management.pojo.OperateLog;
import com.rainsun.d5_tlias_web_management.utils.JWTUtils;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Arrays;

@Slf4j
@Aspect
@Component
public class LogAspect {
    @Autowired
    private OperateLogMapper operateLogMapper;

    @Autowired
    private HttpServletRequest request;

    @Around("@annotation(com.rainsun.d5_tlias_web_management.AOP.Log)")
    public Object recordLog(ProceedingJoinPoint joinPoint) throws Throwable {
        String token = request.getHeader("token");
        Claims claims = JWTUtils.parseJWT(token);
        Integer operateUser = (Integer) claims.get("id");

        LocalDateTime operateTime = LocalDateTime.now();

        String className = joinPoint.getTarget().getClass().getName();

        String methodName = joinPoint.getSignature().getName();

        Object[] args = joinPoint.getArgs();
        String methodParams = Arrays.toString(args);

        long begin = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long end = System.currentTimeMillis();

        String returnValue = JSONObject.toJSONString(result);

        Long costTime = end - begin;

        OperateLog operateLog = new OperateLog(null, operateUser, operateTime, className, methodName, methodParams, returnValue, costTime);
        operateLogMapper.insert(operateLog);
        log.info("AOP记录的操作日志：{}", operateLog);
        return result;

    }
}
