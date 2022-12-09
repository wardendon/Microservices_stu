package com.wd.order.openfeign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Description TODO
 * @Date 2022-10-25-15-40
 * @Author qianzhikang
 */
@FeignClient(value = "cloud-cart-service", path = "/shop-cart")
public interface ShopCartDemoService {
    /**
     * 查询商品
     *
     * @param cartId 购物项id
     * @return int
     */
    @GetMapping(value = "/getGoodsId")
    int getGoodsId(@RequestParam(value = "cartId") int cartId);

    /**
     * 删除购物车商品
     *
     * @param cartId 购物项id
     * @return Boolean
     */
    @DeleteMapping(value = "/{cartId}")
    Boolean deleteItem(@PathVariable(value = "cartId") int cartId);
}
