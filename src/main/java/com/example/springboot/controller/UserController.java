package com.example.springboot.controller;


import com.example.springboot.entity.User;
import com.example.springboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;



/**
 * *****************************************
 *
 * @author 邓超【dengchao5@jd.com】
 * @date 2017/4/5 15:56
 * *****************************************
 */
@RestController
@Validated
@RequestMapping("/spring/user")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value="/{id}",method = RequestMethod.GET)
    public User get(@NotNull @PathVariable Long id){
        User user = userRepository.findOne(id);
        return user;
    }

    @RequestMapping(method = RequestMethod.POST)
    public User post(@NotNull @RequestBody User user){
        user = userRepository.save(user);
        return user;
    }

    @RequestMapping(method = RequestMethod.PUT)
    public void put(@NotNull User user){
        userRepository.save(user);
    }

    @RequestMapping(value="/{id}",method = RequestMethod.DELETE)
    public void delete(@NotNull @PathVariable Long id){
        userRepository.delete(id);
    }
}
