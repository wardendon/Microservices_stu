package top.w2gd.consumer.api;
import java.io.IOException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import javax.annotation.Resource;

/**
 * @author w2gd
 */
@RestController
public class ConsumerController {

    // private final String SERVICE_URL = "https://8ec8-221-226-155-12.ap.ngrok.io";
    private final String SERVICE_URL = "https://86e6-221-226-155-12.ap.ngrok.io";
    private final String SERVICE_URL2 = "http://47.101.62.73:8080";
    @Resource
    private RestTemplate restTemplate;

    private WebClient webClient = WebClient.builder()
            .baseUrl(SERVICE_URL)
            .build();

    @GetMapping("hc")
    public String httpClientTest() throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        // 创建HTTP get请求
        HttpGet httpGet = new HttpGet(SERVICE_URL+"/listUsers");
        CloseableHttpResponse response = null;
        try {
            response = httpClient.execute(httpGet);
            System.out.println(response.getStatusLine().getStatusCode());
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode == 200){
                String res = EntityUtils.toString(response.getEntity(),"utf-8");
                System.out.println(res);
            }

        } catch (IOException e) {
            System.err.println(e.getMessage());
        }finally {
            if (response != null){
                response.close();
            }
            httpClient.close();
        }
        return "请求成功！";
    }

    @GetMapping("rest")
    public String restTemplateTest() {
        System.out.println(restTemplate.getForObject(SERVICE_URL2+"/hello",String.class));
        return restTemplate.getForObject(SERVICE_URL2+"/hello",String.class);
    }

    @GetMapping("wc")
    private String webClientTest(){
        Mono<String> mono = webClient.get().uri("/api/get-pic").retrieve().bodyToMono(String.class);
        mono.subscribe(System.out::println);
        return "请求成功";
    }
}

