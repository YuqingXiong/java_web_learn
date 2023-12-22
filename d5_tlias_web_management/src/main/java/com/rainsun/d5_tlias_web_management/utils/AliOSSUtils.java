package com.rainsun.d5_tlias_web_management.utils;
import com.aliyun.oss.ClientException;
import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.OSSException;
import com.aliyun.oss.model.PutObjectRequest;
import com.aliyun.oss.model.PutObjectResult;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

@Component
public class AliOSSUtils {
//    private String endpoint = "https://oss-cn-qingdao.aliyuncs.com";
//    private String accessKeyId = "LTAI5tHFXTmuMjYh4NQ1mFHN";
//    private String accessKeySecret = "A9MOLk89EOg6yzVzNvN1MByhjPUODZ";
//    private String bucketName = "xiongyuqing-javaweb";

    // 用 Value 注解实现外部配置的属性注入
    @Value("${aliyun.oss.endpoint}")
    private String endpoint;
    @Value("${aliyun.oss.accessKeyId}")
    private String accessKeyId;
    @Value("${aliyun.oss.accessKeySecret}")
    private String accessKeySecret;
    @Value("${aliyun.oss.bucketName}")
    private String bucketName;

    public String upload(MultipartFile multipartFile) throws IOException {
        String oriFileName = multipartFile.getOriginalFilename();
        String fileName = UUID.randomUUID() + oriFileName.substring(oriFileName.lastIndexOf("."));
        // 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);

        // 1. 文件上传的输入流
        InputStream inputStream = multipartFile.getInputStream();
        // 2. PutObject请求上传文件到OSS
        ossClient.putObject(bucketName, fileName, inputStream);
        // 3. 上传到云的文件url
        String url = endpoint.split("//") [0] + "//" + bucketName + "." + endpoint.split("//")[1]+"/"+fileName;
        // 4. 关闭ossClient
        ossClient.shutdown();
        return url;
    }
}
