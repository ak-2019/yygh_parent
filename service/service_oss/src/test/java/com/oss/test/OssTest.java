package com.oss.test;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;

/**
 * <p>
 *
 * </p>
 *
 * @Author chengankang
 * @Date 2022/12/11 10:52
 * @Description
 */
public class OssTest {

    public static void main(String[] args) {
        // Endpoint以杭州为例，其它Region请按实际情况填写。
        String endpoint = "https://oss-cn-hangzhou.aliyuncs.com";
        String accessKeyId = "LTAI5t9yDJ7qXTL7D2sYGJzj";
        String accessKeySecret = "4dOUhnZmHeZ62dPopISVN7jNRmxubB";
        String bucketName = "ak02-file";

        // 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);

        // 创建存储空间。
        ossClient.createBucket(bucketName);

        // 关闭OSSClient。
        ossClient.shutdown();
    }
}
