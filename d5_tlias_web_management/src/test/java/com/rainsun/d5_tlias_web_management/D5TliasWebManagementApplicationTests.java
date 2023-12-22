package com.rainsun.d5_tlias_web_management;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class D5TliasWebManagementApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    public void genJwt(){
        Map<String,Object> claims = new HashMap<>();
        claims.put("id",1);
        claims.put("username","Tom");
        String jwt = Jwts.builder()
                .setClaims(claims) //自定义内容(载荷)
                .signWith(SignatureAlgorithm.HS256, "itheima") //签名算法
                .setExpiration(new Date(System.currentTimeMillis() +
                        24*3600*1000)) //有效期
                .compact();
        System.out.println(jwt);
    }

    @Test
    public void parseJwt(){
        Claims claims = Jwts.parser()
                .setSigningKey("itheima")//指定签名密钥（必须保证和生成令牌时使用 相同的签名密钥）
                .parseClaimsJws("eyJhbGciOiJIUzI1NiJ9.eyJpZCI6MSwiZXhwIjoxNzAyMzYxMDQ1LCJ1c2VybmFtZSI6IlRvbSJ9.7uMS1r3o6js129K2cFNP-bE_7LtDD_bvEUEtQPqPirk")
                .getBody();
        System.out.println(claims);
    }

}
