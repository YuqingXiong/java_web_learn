package com.rainsun.d5_tlias_web_management.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PageBean {
    private Long total;
    private List<Emp> rows;
}
