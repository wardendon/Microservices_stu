package com.qzk.shopcart.controller;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @Description TODO
 * @Date 2022-10-25-15-17
 * @Author qianzhikang
 */
@RestController
public class CloudShopCartApi {
    @Resource
    private JdbcTemplate jdbcTemplate;

    @GetMapping("/shop-cart/getGoodsId")
    public int getGoodsId(@RequestParam("cartId") int cartId) {
        // 根据主键id查询购物表
        Map<String, Object> cartItemObject = jdbcTemplate.queryForMap("select * from tb_cart_item where cart_id=" + cartId + " limit 1");
        if (cartItemObject.containsKey("goods_id")) {
            // 返回商品id
            return (int) cartItemObject.get("goods_id");
        }
        return 0;
    }

    @DeleteMapping("/shop-cart/{cartId}")
    public Boolean deleteItem(@PathVariable("cartId") int cartId) {
        // 删除购物车数据
        int result = jdbcTemplate.update("delete from tb_cart_item where cart_id=" + cartId);
        return result > 0;
    }
}
