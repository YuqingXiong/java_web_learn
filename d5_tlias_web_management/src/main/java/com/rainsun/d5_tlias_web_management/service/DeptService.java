package com.rainsun.d5_tlias_web_management.service;

import com.rainsun.d5_tlias_web_management.pojo.Dept;

import java.util.List;

public interface DeptService {
    List<Dept> list();

    void delete(Integer id);

    void add(Dept dept);
}
