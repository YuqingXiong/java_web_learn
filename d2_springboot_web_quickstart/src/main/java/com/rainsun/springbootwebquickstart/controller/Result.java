package com.rainsun.springbootwebquickstart.controller;

public class Result {
    private Integer code; // 响应状态码，1成功，0失败
    private String msg; // 状态码描述信息
    private Object data; // 返回的响应数据

    public Result() {
    }

    public Result(Integer code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    // 设置几个静态方法，返回不同的结果

    // 增删改的成功响应（不需要返回数据）
    public static Result Success(){
        return new Result(1, "success", null);
    }

    // 查询的成功响应
    public static Result Success(Object data){
        return new Result(1, "success", data);
    }

    // 失败的响应
    public static Result error(String msg){
        return new Result(0, msg, null);
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
