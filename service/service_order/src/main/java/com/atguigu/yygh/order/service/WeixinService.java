package com.atguigu.yygh.order.service;

import java.util.Map;

/**
 * <p>
 *
 * </p>
 *
 * @Author chengankang
 * @Date 2022/12/24 15:11
 * @Description
 */
public interface WeixinService {

    /***
     * 退款
     * @param orderId
     * @return
     */
    Boolean refund(Long orderId);

    /**
     * 根据订单号下单，生成支付链接
     */
    Map createNative(Long orderId);

    /**
     * 根据订单号去微信第三方查询支付状态
     */
    Map queryPayStatus(Long orderId, String paymentType);
}
