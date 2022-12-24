package com.atguigu.yygh.msm.service;

import com.atguigu.yygh.vo.msm.MsmVo;

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

    //MQ发送短信
    boolean send(MsmVo msmVo);
}
