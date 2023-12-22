package com.rainsun.d5_tlias_web_management.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Result {
    private Integer code;
    private String msg;
    private Object data;


    public static Result success(){
        return new Result(1, "Success", null);
    }

    public static Result success(Object data){
        return new Result(1, "Success", data);
    }

    public static Result error(String msg){
        return new Result(0,msg, null);
    }
}
