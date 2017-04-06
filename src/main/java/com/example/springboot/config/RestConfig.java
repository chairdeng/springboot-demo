package com.example.springboot.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;

/**
 * Created by dengchao5 on 2017/4/6.
 */
@SpringBootConfiguration
public class RestConfig {
    @Value("${rest.uri}")
    private String uri;
    @Value("${rest.user}")
    private String userName;
    @Value("${rest.password}")
    private String password;
    @Bean
    public RestTemplateBuilder restTemplateBuilder(){
        return new RestTemplateBuilder().rootUri(uri).basicAuthorization(userName,password);
    }
}
