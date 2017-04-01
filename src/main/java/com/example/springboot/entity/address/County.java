package com.example.springboot.entity.address;

import lombok.Data;

/**
 * *****************************************
 * 县区
 * @author 邓超【dengchao5@jd.com】
 * @date 2017/3/31 18:08
 * *****************************************
 */
@Data
public class County extends Region {
    private City city;
}
