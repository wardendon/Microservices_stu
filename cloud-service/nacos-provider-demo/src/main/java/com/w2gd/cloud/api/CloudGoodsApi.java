package com.w2gd.cloud.api;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author w2gd
 * @description: 商品微服务接口
 */
@RestController
public class CloudGoodsApi {
    @Value("8091")
    private String applicationServerPort;

    @GetMapping("/gst")
    public String goodsServiceTest(){
        // 返回信息个i调用端
        return "this is goods service from port:" + applicationServerPort;
    }
}
