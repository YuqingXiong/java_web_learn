package com.rainsun.d5_tlias_web_management.controller;

import com.rainsun.d5_tlias_web_management.pojo.Result;
import com.rainsun.d5_tlias_web_management.utils.AliOSSUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Slf4j
@RestController
public class UploadController {

//    @PostMapping("/upload")
//    Result upload(String username, Integer age, MultipartFile image) throws IOException {
//        log.info("上传了文件：{}, {}, {}", username, age, image);
//        String filename = image.getOriginalFilename();
//        String extname = filename.substring(filename.lastIndexOf("."));
//        String newFileName = UUID.randomUUID() + extname;
//        image.transferTo(new File("D:\\CodeProject\\Java\\WebProject\\d5_tlias_web_management\\src\\main\\resources\\storeFiles\\"+newFileName));
//        return Result.success();
//    }

    @Autowired
    private AliOSSUtils aliOSSUtils;

    @PostMapping("/upload")
    Result upload(MultipartFile image) throws IOException {
        String url = aliOSSUtils.upload(image);
        return Result.success(url);
    }
}
