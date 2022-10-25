package com.qzk.order.controller;

import com.qzk.order.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Description TODO
 * @Date 2022-10-25-15-44
 * @Author qianzhikang
 */
@RestController
public class CloudOrderApi {
    @Resource
    private OrderService orderService;

    @GetMapping("/order/saveOrder")
    public Boolean saveOrder(@RequestParam("cartId") int cartId) {
        return orderService.saveOrder(cartId);
    }
}