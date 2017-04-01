package com.example.springboot.repository;

import com.example.springboot.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * *****************************************
 *
 * @author 邓超【dengchao5@jd.com】
 * @date 2017/4/1 17:22
 * *****************************************
 */
@Repository
public interface UserRepository extends CrudRepository<User,Long> {
}
