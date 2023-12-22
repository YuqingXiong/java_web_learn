package com.rainsun.d5_tlias_web_management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
public class D5TliasWebManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(D5TliasWebManagementApplication.class, args);
    }

}
