package com.rainsun.d5_tlias_web_management.mapper;

import com.rainsun.d5_tlias_web_management.pojo.Emp;
import org.apache.ibatis.annotations.*;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface EmpMapper {

//    @Select("select count(*) from emp")
//    Long count();

//    @Select("select * from emp limit #{start}, #{pageSize}")
//    List<Emp> list(Integer start, Integer pageSize);

//    @Select("select * from emp")
//    List<Emp> list();

    // xml 实现
    List<Emp> list(String name, Short gender, LocalDate begin, LocalDate end);

    void delete(List<Integer> ids);
    
    @Delete("delete from emp where id=#{id}")
    void deleteByDeptId(Integer id);

    @Insert("insert into emp(username, name, gender, image, job, entrydate, dept_id, create_time, update_time)" +
            "values(#{username}, #{name}, #{gender}, #{image}, #{job}, #{entrydate}, #{deptId}, #{createTime}, #{updateTime})")
    void insert(Emp emp);


    @Select("select * from emp where id=#{id}")
    Emp getById(Integer id);


    void update(Emp emp);

    @Select("select * from emp where username=#{username} and password=#{password}")
    Emp getByUsernameAndPassword(Emp emp);
}
