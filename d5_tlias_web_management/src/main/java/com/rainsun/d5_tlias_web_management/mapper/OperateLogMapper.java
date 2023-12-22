package com.rainsun.d5_tlias_web_management.mapper;

import com.rainsun.d5_tlias_web_management.pojo.OperateLog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OperateLogMapper {
    @Insert("insert into operate_log(id, operate_user, operate_time, class_name, method_name, method_params, return_value, cost_time)" +
            "values (#{id}, #{operateUser}, #{operateTime}, #{className}, #{methodName}, #{methodParams}, #{returnValue}, #{costTime})")
    void insert(OperateLog operateLog);
}
