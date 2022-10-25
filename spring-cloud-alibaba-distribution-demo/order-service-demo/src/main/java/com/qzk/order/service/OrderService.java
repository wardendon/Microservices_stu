package com.qzk.order.service;

import com.qzk.order.openfeign.GoodsDemoService;
import com.qzk.order.openfeign.ShopCartDemoService;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @Description TODO
 * @Date 2022-10-25-15-40
 * @Author qianzhikang
 */
@Service
public class OrderService {
    @Resource
    private JdbcTemplate jdbcTemplate;

    @Resource
    private GoodsDemoService goodsDemoService;

    @Resource
    private ShopCartDemoService shopCartDemoService;

    @Transactional(rollbackFor = {RuntimeException.class})
    public Boolean saveOrder(int cartId) {
        // 简单的模拟下单流程，包括服务间的调用流程。

        // 调用购物车服务-获取即将操作的goods_id
        int goodsId = shopCartDemoService.getGoodsId(cartId);

        // 调用商品服务-减库存
        Boolean goodsResult = goodsDemoService.deStock(goodsId);

        // 调用购物车服务-删除当前购物车数据
        Boolean cartResult = shopCartDemoService.deleteItem(cartId);

        // 执行下单逻辑
        if (goodsResult && cartResult) {
            // 向订单表中新增一条记录
            int orderResult = jdbcTemplate.update("insert into tb_order(`cart_id`) value (\"" + cartId + "\")");
            // 出现异常
            int i = 1 / 0;
            return orderResult > 0;
        }
        return false;
    }
}