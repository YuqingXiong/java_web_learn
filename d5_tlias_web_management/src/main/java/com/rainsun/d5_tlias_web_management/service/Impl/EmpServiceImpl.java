package com.rainsun.d5_tlias_web_management.service.Impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.rainsun.d5_tlias_web_management.AOP.Log;
import com.rainsun.d5_tlias_web_management.mapper.EmpMapper;
import com.rainsun.d5_tlias_web_management.pojo.Emp;
import com.rainsun.d5_tlias_web_management.pojo.PageBean;
import com.rainsun.d5_tlias_web_management.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static com.sun.tools.attach.VirtualMachine.list;

@Service
@Slf4j
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpMapper empMapper;
//    @Override
//    public PageBean page(Integer page, Integer pageSize) {
////        Long total = empMapper.count();
////        Integer start = (page-1)*pageSize;
////        List<Emp> empList = empMapper.list(start, pageSize);
//        PageHelper.startPage(page, pageSize);
//        Page<Emp> empPage = (Page<Emp>) empMapper.list(null, null, null, null);
//        return new PageBean(empPage.getTotal(), empPage.getResult());
//    }

    @Override
    public PageBean page(Integer page, Integer pageSize, String name, Short gender, LocalDate begin, LocalDate end) {
        PageHelper.startPage(page, pageSize);
        Page<Emp> empPage = (Page<Emp>) empMapper.list(name, gender, begin, end);
        return new PageBean(empPage.getTotal(), empPage.getResult());
    }

    @Log
    @Override
    public void delete(List<Integer> ids) {
        empMapper.delete(ids);
    }

    @Log
    @Override
    public void save(Emp emp) {
        emp.setCreateTime(LocalDateTime.now());
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.insert(emp);
    }

    @Override
    public Emp getById(Integer id) {
        return empMapper.getById(id);
    }

    @Log
    @Override
    public void update(Emp emp) {
        empMapper.update(emp);
    }

    @Override
    public Emp login(Emp emp) {
        return empMapper.getByUsernameAndPassword(emp);
    }

    @Override
    public void deleteByDeptId(Integer id) {
        empMapper.deleteByDeptId(id);
    }
}
