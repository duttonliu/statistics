package com.ldt.statistics.utils;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * 百度账号
 *
 * @author LiuDeTong
 * @date 2020/12/10 15:58
 */
@Component
@Data
@ConfigurationProperties(prefix = "baidu.personal")
public class BaiduPersonalUtil {

    private String authorize;

    private String token;

    private String apiKey;

    private String secretKey;

    private String callBackUri;

    @Autowired
    private RestTemplate restTemplate;

    public void authorize() {
        String url = authorize.replace("{CLIENT_ID}", apiKey).replace("{REDIRECT_URI}", callBackUri);
        System.err.println(url);
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(url, String.class);
        System.err.println(responseEntity.getBody());
    }

    public void token(String code) {
        String url = token.replace("{CODE}", code).replace("{CLIENT_ID}", apiKey).replace("{CLIENT_SECRET}", secretKey).replace("{REDIRECT_URI}", callBackUri);
        System.err.println(url);
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(url, String.class);
        System.err.println(responseEntity.getBody());
    }
}
