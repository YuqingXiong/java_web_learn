package com.rainsun.d5_tlias_web_management.service.Impl;

import com.rainsun.d5_tlias_web_management.AOP.Log;
import com.rainsun.d5_tlias_web_management.mapper.DeptMapper;
import com.rainsun.d5_tlias_web_management.mapper.EmpMapper;
import com.rainsun.d5_tlias_web_management.pojo.Dept;
import com.rainsun.d5_tlias_web_management.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Slf4j
public class DeptServiceImpl implements DeptService {
    @Autowired
    private DeptMapper deptMapper;

    @Autowired
    private EmpMapper empMapper;

    @Override
    public List<Dept> list() {
        List<Dept> deptList = deptMapper.list();

        return deptList;
    }

    @Log
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void delete(Integer id) {
        deptMapper.delete(id);

        empMapper.deleteByDeptId(id);
    }

    @Log
    @Override
    public void add(Dept dept) {
        dept.setCreateTime(LocalDateTime.now());
        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.add(dept);
    }
}
