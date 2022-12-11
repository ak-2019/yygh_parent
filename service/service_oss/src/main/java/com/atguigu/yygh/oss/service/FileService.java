package com.atguigu.yygh.oss.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * <p>
 *
 * </p>
 *
 * @Author chengankang
 * @Date 2022/12/11 10:48
 * @Description
 */
public interface FileService {
    //上传文件到阿里云oss
    String upload(MultipartFile file);
}
