package com.atguigu.yygh.order.service;

import com.atguigu.yygh.model.order.OrderInfo;
import com.atguigu.yygh.model.order.PaymentInfo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;


/**
 * <p>
 *
 * </p>
 *
 * @Author chengankang
 * @Date 2022/12/24 15:13
 * @Description
 */
public interface PaymentService extends IService<PaymentInfo> {

    /**
     * 获取支付记录
     * @param orderId
     * @param paymentType
     * @return
     */
    PaymentInfo getPaymentInfo(Long orderId, Integer paymentType);

    /**
     * 支付成功
     */
    void paySuccess(String outTradeNo, Integer paymentType, Map<String, String> paramMap);

    /**
     * 保存交易记录
     *
     * @param order
     * @param paymentType 支付类型（1：微信 2：支付宝）
     */
    void savePaymentInfo(OrderInfo order, Integer paymentType);

}
