package com.example.springboot.entity.address;

import lombok.Data;

/**
 * *****************************************
 * 行政区划抽象
 * @author 邓超【dengchao5@jd.com】
 * @date 2017/3/31 18:05
 * *****************************************
 */
@Data
public abstract class Region {
    protected String code;
    protected String name;
}
