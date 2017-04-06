package com.example.springboot.service;

import com.example.springboot.entity.User;
import com.example.springboot.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * Created by dengchao5 on 2017/4/6.
 */
@Service
@Slf4j
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @CachePut(value="userCache",key="#user.id")
    public void saveUser(User user){
        userRepository.save(user);
    }

    @Cacheable(value="userCache",key="#id")
    public User getUser(Long id){
        return userRepository.findOne(id);
    }

    @CacheEvict(value="userCache",key="#id")
    public void deleteUser(Long id){
        userRepository.delete(id);
    }
}
