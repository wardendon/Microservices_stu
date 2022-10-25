package com.qzk.order.openfeign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

/**
 * @Description TODO
 * @Date 2022-10-25-15-39
 * @Author qianzhikang
 */
@FeignClient(value = "cloud-goods-service", path = "/goods")
public interface GoodsDemoService {
    /**
     * 减库存
     *
     * @param goodsId 商品id
     * @return Boolean
     */
    @PutMapping(value = "/{goodsId}")
    Boolean deStock(@PathVariable(value = "goodsId") int goodsId);
}