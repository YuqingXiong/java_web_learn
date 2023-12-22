package com.rainsun.d5_tlias_web_management.controller;

import com.rainsun.d5_tlias_web_management.pojo.Emp;
import com.rainsun.d5_tlias_web_management.pojo.Result;
import com.rainsun.d5_tlias_web_management.service.EmpService;
import com.rainsun.d5_tlias_web_management.utils.JWTUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;


@Slf4j
@RestController
public class LoginController {

    @Autowired
    private EmpService empService;

    @PostMapping("/login")
    public Result login(@RequestBody Emp emp){
        Emp loginEmp = empService.login(emp);
        if(loginEmp != null){
            // 自定义信息
            Map<String, Object> claims = new HashMap<>();
            claims.put("id", loginEmp.getId());
            claims.put("username", loginEmp.getUsername());
            claims.put("name", loginEmp.getName());

            // 生成身份令牌
            String token = JWTUtils.generateJwt(claims);
            return Result.success(token);
        }
        return Result.error("用户名或密码错误");
    }
}
