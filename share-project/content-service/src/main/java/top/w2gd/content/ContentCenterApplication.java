package top.w2gd.content;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author w2gd
 */
@SpringBootApplication
// @EnableFeignClients(clients = {top.w2gd.content.openfeign.UserService.class})
@EnableFeignClients(basePackages = {"top.w2gd.content"})
public class ContentCenterApplication {
    public static void main(String[] args) {
        SpringApplication.run(ContentCenterApplication.class,args);
    }
}
