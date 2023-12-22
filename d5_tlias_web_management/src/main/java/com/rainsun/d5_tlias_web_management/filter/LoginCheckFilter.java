package com.rainsun.d5_tlias_web_management.filter;

import com.alibaba.fastjson.JSONObject;
import com.rainsun.d5_tlias_web_management.pojo.Result;
import com.rainsun.d5_tlias_web_management.utils.JWTUtils;
import io.jsonwebtoken.Jwts;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import java.io.IOException;

@Slf4j
@WebFilter(urlPatterns = "/*")
public class LoginCheckFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        String url = request.getRequestURL().toString();
        log.info("请求路径：{}", url);

        if(url.contains("/login")){
            filterChain.doFilter(request, response);
            return;
        }

        String token = request.getHeader("token");
        log.info("从请求头中获取的令牌：{}", token);

        if(!StringUtils.hasLength(token)){
            log.info("令牌不存在");

            Result responseResult =  Result.error("NOT_LOGIN");
            String jsonString = JSONObject.toJSONString(responseResult);
            response.setContentType("application/json;charset=utf-8");
            response.getWriter().write(jsonString);
            return;
        }

        try {
            JWTUtils.parseJWT(token);
        } catch (Exception e) {
            log.info("token解析失败");
            Result responseResult =  Result.error("NOT_LOGIN");
            String jsonString = JSONObject.toJSONString(responseResult);
            response.setContentType("application/json;charset=utf-8");
            response.getWriter().write(jsonString);
            return;
        }
        filterChain.doFilter(request, response);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
//        Filter.super.init(filterConfig);
    }

    @Override
    public void destroy() {
//        Filter.super.destroy();
    }
}
