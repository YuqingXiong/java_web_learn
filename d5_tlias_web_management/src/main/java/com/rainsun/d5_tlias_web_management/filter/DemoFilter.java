//package com.rainsun.d5_tlias_web_management.filter;
//
//import jakarta.servlet.*;
//import jakarta.servlet.annotation.WebFilter;
//
//import java.io.IOException;
//
//@WebFilter(urlPatterns = "/*")
//public class DemoFilter implements Filter {
//    @Override
//    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//        System.out.println("Filter 拦截到了请求...放行前逻辑");
//
//        filterChain.doFilter(servletRequest, servletResponse);
//
//        System.out.println("Filter 拦截到了请求...放行后逻辑");
//    }
//
//    @Override
//    public void init(FilterConfig filterConfig) throws ServletException {
//        // Filter.super.init(filterConfig);
//        System.out.println("init 初始化方法被执行了");
//    }
//
//    @Override
//    public void destroy() {
//        // Filter.super.destroy();
//        System.out.println("destroy 销毁方法被执行了");
//    }
//}
