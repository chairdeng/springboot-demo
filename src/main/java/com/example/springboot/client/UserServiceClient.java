package com.example.springboot.client;

import com.example.springboot.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

/**
 * Created by dengchao5 on 2017/4/6.
 */
@Service
@Slf4j
public class UserServiceClient {

    @Autowired
    RestTemplateBuilder restTemplateBuilder;

    @Retryable(value = RestClientException.class,maxAttempts = 4,backoff = @Backoff(value = 200))
    public void saveUser(User user){
        RestTemplate restTemplate = restTemplateBuilder.build();
        restTemplate.postForEntity("/users",user,User.class);
    }
    @Recover
    public void recover(RestClientException e){
        log.error("请求REST服务发生异常",e);
    }
}
