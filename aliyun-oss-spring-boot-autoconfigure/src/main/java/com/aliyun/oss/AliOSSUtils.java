package com.aliyun.oss;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

@Data
public class AliOSSUtils {

    private AliOSSProperties aliOSSProperties;

    public String upload(MultipartFile multipartFile) throws IOException {
        String oriFileName = multipartFile.getOriginalFilename();
        String fileName = UUID.randomUUID() + oriFileName.substring(oriFileName.lastIndexOf("."));
        // 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(aliOSSProperties.getEndpoint(), aliOSSProperties.getAccessKeyId(), aliOSSProperties.getAccessKeySecret());

        // 1. 文件上传的输入流
        InputStream inputStream = multipartFile.getInputStream();
        // 2. PutObject请求上传文件到OSS
        ossClient.putObject(aliOSSProperties.getBucketName(), fileName, inputStream);
        // 3. 上传到云的文件url
        String url = aliOSSProperties.getEndpoint().split("//") [0] + "//" + aliOSSProperties.getBucketName() + "." + aliOSSProperties.getEndpoint().split("//")[1]+"/"+fileName;
        // 4. 关闭ossClient
        ossClient.shutdown();
        return url;
    }
}
