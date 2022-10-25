package com.qzk.order;

import com.qzk.order.openfeign.GoodsDemoService;
import com.qzk.order.openfeign.ShopCartDemoService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Description TODO
 * @Date 2022-10-25-15-29
 * @Author qianzhikang
 */
@SpringBootApplication
@EnableFeignClients(clients={ShopCartDemoService.class, GoodsDemoService.class})
public class OrderApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class,args);
    }
}
