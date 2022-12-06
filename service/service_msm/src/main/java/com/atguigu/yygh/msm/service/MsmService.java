package com.atguigu.yygh.msm.service;

/**
 * <p>
 *
 * </p>
 *
 * @Author chengankang
 * @Date 2022/12/5 8:06
 * @Description
 */
public interface MsmService {

    //发送手机验证码
    boolean send(String phone, String code);
}
