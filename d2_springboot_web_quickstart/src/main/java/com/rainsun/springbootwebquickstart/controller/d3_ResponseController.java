package com.rainsun.springbootwebquickstart.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class d3_ResponseController {
    // 当响应的数据不同时，需要统一响应结果，便于前端解析
    @RequestMapping("/ResponseHello")
    public Result hello(){
        System.out.println("Hello World");
//        return "Hello World";
        return Result.Success("Hello World");
    }

    @RequestMapping("/getAddr")
    public Result getAddr(){
        Address address = new Address();
        address.setProvince("山东");
        address.setCity("青岛");
        return Result.Success(address);
    }

    @RequestMapping("/listAddr")
    public Result listAddr(){
        List<Address> addressList = new ArrayList<>();
        Address address1 = new Address();
        address1.setProvince("山东");
        address1.setCity("青岛");
        addressList.add(address1);

        Address address2 = new Address();
        address2.setProvince("湖北");
        address2.setCity("武汉");
        addressList.add(address2);

        return Result.Success(addressList);
    }

}
