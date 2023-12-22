package com.rainsun.springbootmybatiscrud.Mapper;

import com.rainsun.springbootmybatiscrud.pojo.Emp;
import org.apache.ibatis.annotations.*;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface EmpMapper{
    // 根据主键删除数据
    @Delete("delete from emp where id=#{id}")
    public void delete(Integer id);
//    public int delete(Integer id);
    // 返回 int 类型表示影响的数据数量

    // 新增员工
    @Options(useGeneratedKeys = true, keyProperty = "id")  // 将生成的主键值，赋值给id属性
    @Insert("insert into emp(username, name, gender, image, job, entrydate, dept_id, create_time, update_time) " +
            "values (#{username}, #{name}, #{gender}, #{image}, #{job}, #{entrydate}, #{deptId}, #{createTime}, #{updateTime})")
    public void insertEmp(Emp emp);

    // 更新修改员工信息
//    @Update("update emp set username=#{username}, name=#{name}, gender=#{gender}, image=#{image}, job=#{job}, " +
//            "entrydate=#{entrydate}, dept_id=#{deptId}, update_time=#{updateTime} where id=#{id}")
    public void updateEmp(Emp emp);

    // 查询员工信息
    @Select("select id, username, password, name, gender, image, job, entrydate, dept_id, create_time, update_time " +
            "from emp where id=#{id}")
    public Emp selectEmp(Integer id);

    // "where name like '%${name}$%' " : $$的字符串拼接存在SQL注入的安全问题
    // 使用 mysql提供的concat函数进行拼接
//    @Select("select * from emp " +
//            "where name like concat('%', #{name}, '%')" +
//            "and gender=#{gender} and entrydate between #{begin} and #{end} " +
//            "order by update_time desc")
    // xml 写法
    public List<Emp> selectEmpList(String name, Short gender, LocalDate begin, LocalDate end);


    // 批量删除
    public void deleteEmpList(List<Integer> idList);
}
