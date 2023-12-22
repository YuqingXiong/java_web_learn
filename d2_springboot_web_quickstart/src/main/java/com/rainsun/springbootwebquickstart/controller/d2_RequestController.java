package com.rainsun.springbootwebquickstart.controller;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;


@RestController
public class d2_RequestController {
    //springboot方式
    @RequestMapping("/simpleParam")
    public String simpleParam(@RequestParam(name="name", required=false) String username , Integer age ){//请求参数名和形参名不相同
        // required为true表示参数必须传递，false为参数可选
        System.out.println(username+"  :  "+ age);
        return "OK";
    }

    // 实体参数：简单实体对象
    @RequestMapping("/simplePojo")
    public String simplePojo(User user){
        // 属性名与请求参数名相同
        System.out.println(user);
        return "OK";
    }

    // 复杂实体对象：实体类的属性中包含另一个实体
    @RequestMapping("/complexPojo")
    public String complexPojo(User1 user1){//请求参数名和形参名不相同
        // 按照对象层次结构关系即可接收嵌套实体类属性参数
        System.out.println(user1);
        return "OK";
    }

    // 数组集合参数:
    // 数组参数：请求参数名与形参数组名称相同且请求参数为多个，定义数组类型形参即可接收参数
    @RequestMapping("/arrayParam")
    public String arrayParam(String[] hobby){
        System.out.println(Arrays.toString(hobby));
        return "OK";
    }
    // 集合参数：请求参数名与形参集合对象名相同且请求参数为多个，@RequestParam 绑定参数关系
    @RequestMapping("/listParam")
    public String listParam(@RequestParam List<String> hobby){
        System.out.println(hobby);
        return "OK";
    }

    // 日期参数: 通过@DateTimeFormat注解，以及其pattern属性来设置日期的格式
    @RequestMapping("/dateParam")
    public String dateParam(@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime updateTime){
        System.out.println(updateTime);
        return "OK";
    }

    // JSON参数:
    // @RequestBody注解：将JSON数据映射到形参的实体类对象中（JSON中的key和实体类中的属性名保持一致）
    @RequestMapping("/jsonParam")
    public String jsonParam(@RequestBody User1 user1){
        System.out.println(user1);
        return "OK";
    }

    // 路径参数：直接在请求的URL中传递参数
    @RequestMapping("/pathParam/{id}")
    public String pathParam1(@PathVariable Integer id){
        System.out.println(id);
        return "OK";
    }
    // 多个路径参数：
    @RequestMapping("/pathParam/{id}/{name}")
    public String pathParam2(@PathVariable Integer id, @PathVariable String name){
        System.out.println(id + " : " + name);
        return "OK";
    }
}
