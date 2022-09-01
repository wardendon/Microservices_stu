package top.w2gd.provider.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author w2gd
 */
@RestController
@RequestMapping(value = "/api")
public class HelloController {
    @GetMapping("/hello")
    public String getHello(){
        return  "hello world";
    }
}
