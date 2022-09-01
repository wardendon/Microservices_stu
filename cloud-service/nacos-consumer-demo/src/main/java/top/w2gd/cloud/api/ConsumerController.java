package top.w2gd.cloud.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author w2gd
 */
@RestController
public class ConsumerController {

    @Resource
    private RestTemplate restTemplate;

    private final String SERVICE_URL = "http://cloud-goods-service";

    @GetMapping("/consumerTest")
    public String consumerTest(){
        return restTemplate.getForObject(SERVICE_URL+"/gst", String.class);
    }

}
