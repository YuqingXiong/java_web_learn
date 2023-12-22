package com.rainsun.d5_tlias_web_management.controller;

import com.rainsun.d5_tlias_web_management.pojo.Dept;
import com.rainsun.d5_tlias_web_management.pojo.Result;
import com.rainsun.d5_tlias_web_management.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/depts")
public class DeptController {
    @Autowired
    private DeptService deptService;

    @GetMapping
    public Result list(){
        log.info("查询所有部门数据");
        List<Dept> deptList= deptService.list();
        return Result.success(deptList);
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id){
        log.info("根据id删除部门");
        deptService.delete(id);
        return Result.success();
    }

    @PostMapping
    public Result add(@RequestBody Dept dept){
        log.info("新增一个部门：{}", dept);
        deptService.add(dept);
        return Result.success();
    }
}
