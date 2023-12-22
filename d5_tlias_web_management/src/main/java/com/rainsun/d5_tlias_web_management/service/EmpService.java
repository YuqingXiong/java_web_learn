package com.rainsun.d5_tlias_web_management.service;

import com.rainsun.d5_tlias_web_management.pojo.Emp;
import com.rainsun.d5_tlias_web_management.pojo.PageBean;

import java.time.LocalDate;
import java.util.List;

public interface EmpService {
//    PageBean page(Integer page, Integer pageSize);
    PageBean page(Integer page, Integer pageSize, String name, Short gender, LocalDate begin, LocalDate end);

    void delete(List<Integer> ids);

    void deleteByDeptId(Integer id);

    void save(Emp emp);

    Emp getById(Integer id);

    void update(Emp emp);

    Emp login(Emp emp);
}
