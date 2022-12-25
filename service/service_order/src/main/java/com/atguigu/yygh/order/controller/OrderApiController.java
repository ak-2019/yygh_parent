package com.atguigu.yygh.order.controller;

import com.atguigu.yygh.common.result.Result;
import com.atguigu.yygh.common.utils.AuthContextHolder;
import com.atguigu.yygh.enums.OrderStatusEnum;
import com.atguigu.yygh.model.order.OrderInfo;
import com.atguigu.yygh.order.service.OrderService;
import com.atguigu.yygh.vo.order.OrderCountQueryVo;
import com.atguigu.yygh.vo.order.OrderQueryVo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * <p>
 *
 * </p>
 *
 * @Author chengankang
 * @Date 2022/12/11 15:53
 * @Description
 */
@Api(tags = "订单接口")
@RestController
@RequestMapping("/api/order/orderInfo")
public class OrderApiController {

    @Autowired
    private OrderService orderService;

    @ApiOperation(value = "创建订单")
    @PostMapping("/auth/submitOrder/{scheduleId}/{patientId}")
    public Result submitOrder(
            @ApiParam(name = "scheduleId", value = "排班id", required = true) @PathVariable String scheduleId,
            @ApiParam(name = "patientId", value = "就诊人id", required = true) @PathVariable Long patientId) {
        System.err.println("进来：撒大苏打" + "创建订单");
        return Result.ok(orderService.saveOrder(scheduleId, patientId));
    }

    //订单列表（条件查询带分页）
    @GetMapping("auth/{page}/{limit}")
    public Result list(@PathVariable Long page, @PathVariable Long limit,
                       OrderQueryVo orderQueryVo, HttpServletRequest request) {
        //设置当前用户id
        orderQueryVo.setUserId(AuthContextHolder.getUserId(request));
        Page<OrderInfo> pageParam = new Page<>(page, limit);
        IPage<OrderInfo> pageModel = orderService.selectPage(pageParam, orderQueryVo);
        return Result.ok(pageModel);
    }

    @ApiOperation(value = "获取订单状态")
    @GetMapping("auth/getStatusList")
    public Result getStatusList() {
        return Result.ok(OrderStatusEnum.getStatusList());
    }

    //根据订单id查询订单详情
    @GetMapping("auth/getOrderInfo/{orderId}")
    public Result getOrders(@PathVariable String orderId) {
        OrderInfo orderInfo = orderService.getOrder(orderId);
        return Result.ok(orderInfo);
    }

    @ApiOperation(value = "取消预约")
    @GetMapping("auth/cancelOrder/{orderId}")
    public Result cancelOrder(@ApiParam(name = "orderId", value = "订单id", required = true) @PathVariable("orderId") Long orderId) {
        return Result.ok(orderService.cancelOrder(orderId));
    }

    @ApiOperation(value = "获取订单统计数据")
    @PostMapping("inner/getCountMap")
    public Map<String, Object> getCountMap(@RequestBody OrderCountQueryVo orderCountQueryVo) {
        return orderService.getCountMap(orderCountQueryVo);
    }

}
