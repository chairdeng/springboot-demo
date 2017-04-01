package com.example.springboot.entity;

import com.example.springboot.entity.address.County;
import lombok.Data;
import org.springframework.data.geo.Point;
import org.springframework.validation.annotation.Validated;

/**
 * *****************************************
 * 地址
 * @author 邓超【dengchao5@jd.com】
 * @date 2017/3/31 17:49
 * *****************************************
 */
@Data
public class Address {
    private long id;
    //邮政编码
    private String postcode;
    //区县
    private County county;
    //街道
    private String street;
    //门牌号
    private String hausnummer;
    //地理位置
    private Point position;
}
