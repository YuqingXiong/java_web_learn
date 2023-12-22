package com.rainsun.springbootmybatisquickstart.mapper;

import com.rainsun.springbootmybatisquickstart.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper // 运行时自动生成实现类对象，并交给IOC管理
public interface UserMapper {
    // 查询全部用户信息
    @Select("select * from user")
    public List<User> list();
}
