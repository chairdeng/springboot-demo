package com.example.springboot.entity.address;

import lombok.Data;

/**
 * *****************************************
 *
 * @author 邓超【dengchao5@jd.com】
 * @date 2017/3/31 18:06
 * *****************************************
 */
@Data
public class City extends Region {
    private Province province;
}
